package br.com.jtech.services.togaf.core.application.usecases.comment;

import br.com.jtech.services.togaf.core.application.domains.Comment;
import br.com.jtech.services.togaf.core.application.domains.Phase;
import br.com.jtech.services.togaf.core.application.domains.User;
import br.com.jtech.services.togaf.core.application.exceptions.CommentNotValidException;
import br.com.jtech.services.togaf.core.application.exceptions.PhaseNotFoundException;
import br.com.jtech.services.togaf.core.application.exceptions.UserNotFoundException;
import br.com.jtech.services.togaf.core.application.usecases.comment.ports.input.DeleteCommentByPhaseInputGateway;
import br.com.jtech.services.togaf.core.application.usecases.comment.ports.output.DeleteCommentOutputGateway;
import br.com.jtech.services.togaf.core.application.usecases.comment.ports.output.FindCommentByUserAndPhaseAndCreatedAtOutputGateway;
import br.com.jtech.services.togaf.core.application.usecases.phase.ports.output.FindPhaseByIdOutputGateway;
import br.com.jtech.services.togaf.core.application.usecases.user.ports.output.FindUserByEmailOutputGateway;

import java.time.LocalDate;
import java.util.Optional;

public class DeleteCommentByPhaseUseCase implements DeleteCommentByPhaseInputGateway {

    private final FindCommentByUserAndPhaseAndCreatedAtOutputGateway findCommentByUserAndPhaseAndCreatedAtOutputGateway;
    private final FindUserByEmailOutputGateway findUserByEmailOutputGateway;
    private final DeleteCommentOutputGateway deleteCommentOutputGateway;
    private final FindPhaseByIdOutputGateway findPhaseByIdOutputGateway;

    public DeleteCommentByPhaseUseCase(final FindCommentByUserAndPhaseAndCreatedAtOutputGateway findCommentByUserAndPhaseAndCreatedAtOutputGateway,
                                       final FindUserByEmailOutputGateway findUserByEmailOutputGateway,
                                       final DeleteCommentOutputGateway deleteCommentOutputGateway,
                                       final FindPhaseByIdOutputGateway findPhaseByIdOutputGateway) {
        this.findCommentByUserAndPhaseAndCreatedAtOutputGateway = findCommentByUserAndPhaseAndCreatedAtOutputGateway;
        this.findUserByEmailOutputGateway = findUserByEmailOutputGateway;
        this.deleteCommentOutputGateway = deleteCommentOutputGateway;
        this.findPhaseByIdOutputGateway = findPhaseByIdOutputGateway;
    }

    @Override
    public void delete(Comment comment) {
        if (!comment.isValid()) {
            throw new CommentNotValidException("Comment is not valid!");
        }

        User user = findUser(comment.getUser());
        Phase phase = findPhase(comment.getPhase());
        Optional<Comment> foundComment = findCommentByParams(user, phase, comment.getCreatedAt());

        foundComment.ifPresent(this::deleteComment);
    }

    private void deleteComment(Comment comment) {
        deleteCommentOutputGateway.delete(comment);
    }

    private Phase findPhase(Phase phase) {
        return findPhaseByIdOutputGateway.findById(phase.getId())
                .orElseThrow(() -> new PhaseNotFoundException("Phase not found!"));
    }

    private User findUser(User user) {
        return findUserByEmailOutputGateway.findByEmail(user.getEmail())
                .orElseThrow(() -> new UserNotFoundException("User not found!"));
    }

    private Optional<Comment> findCommentByParams(User user, Phase phase, LocalDate createdAt) {
        return findCommentByUserAndPhaseAndCreatedAtOutputGateway.findByUserAndPhaseAndCreateAt(user, phase, createdAt);
    }
}
