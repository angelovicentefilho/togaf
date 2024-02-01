package br.com.jtech.services.togaf.core.application.core.usecases.comment;

import br.com.jtech.services.togaf.core.application.core.domains.Comment;
import br.com.jtech.services.togaf.core.application.core.domains.Phase;
import br.com.jtech.services.togaf.core.application.core.domains.Project;
import br.com.jtech.services.togaf.core.application.core.exceptions.CommentNotValidException;
import br.com.jtech.services.togaf.core.application.core.exceptions.CommentProjectOrPhaseException;
import br.com.jtech.services.togaf.core.application.ports.input.CreateCommentInputGateway;
import br.com.jtech.services.togaf.core.application.ports.output.CreateCommentOutputGateway;
import br.com.jtech.services.togaf.core.application.ports.output.FindPhaseByIdOutputGateway;
import br.com.jtech.services.togaf.core.application.ports.output.FindProjectByIdOutputGateway;

import java.util.Optional;

public class CreateCommentUseCase implements CreateCommentInputGateway {

    private final CreateCommentOutputGateway createCommentOutputGateway;
    private final FindProjectByIdOutputGateway findProjectByIdOutputGateway;
    private final FindPhaseByIdOutputGateway findPhaseByIdOutputGateway;

    public CreateCommentUseCase(final CreateCommentOutputGateway createCommentOutputGateway,
                                final FindProjectByIdOutputGateway findProjectByIdOutputGateway,
                                final FindPhaseByIdOutputGateway findPhaseByIdOutputGateway) {
        this.createCommentOutputGateway = createCommentOutputGateway;
        this.findProjectByIdOutputGateway = findProjectByIdOutputGateway;
        this.findPhaseByIdOutputGateway = findPhaseByIdOutputGateway;
    }

    @Override
    public Optional<Comment> create(Comment comment) {
        if (!comment.isValid()) {
            throw new CommentNotValidException("Comment is not valid.");
        }

        Optional<Project> project = findProjectById(comment.getProject().getId());
        Optional<Phase> phase = findPhaseById(comment.getPhase().getId());

        if (project.isPresent() && phase.isPresent()) {
            comment.setProject(project.get());
            comment.setPhase(phase.get());
            return createCommentOutputGateway.create(comment);
        }

        throw new CommentProjectOrPhaseException("Cannot create comment. Project or Phase not found.");
    }

    private Optional<Project> findProjectById(Long id) {
        return this.findProjectByIdOutputGateway.findById(id);
    }

    private Optional<Phase> findPhaseById(Long id) {
        return this.findPhaseByIdOutputGateway.findById(id);
    }
}
