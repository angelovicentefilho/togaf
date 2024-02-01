package br.com.jtech.services.togaf.core.application.core.usecases.comment;

import br.com.jtech.services.togaf.core.application.core.domains.Comment;
import br.com.jtech.services.togaf.core.application.core.exceptions.CommentNotFoundException;
import br.com.jtech.services.togaf.core.application.core.exceptions.CommentNotValidException;
import br.com.jtech.services.togaf.core.application.ports.input.UpdateCommentInputGateway;
import br.com.jtech.services.togaf.core.application.ports.output.FindCommentByIdOutputGateway;
import br.com.jtech.services.togaf.core.application.ports.output.UpdateCommentOutputGateway;

import java.util.Optional;

public class UpdateCommentUseCase implements UpdateCommentInputGateway {

    private final UpdateCommentOutputGateway updateCommentOutputGateway;
    private final FindCommentByIdOutputGateway findCommentByIdOutputGateway;

    public UpdateCommentUseCase(final UpdateCommentOutputGateway updateCommentOutputGateway,
                                final FindCommentByIdOutputGateway findCommentByIdOutputGateway) {
        this.updateCommentOutputGateway = updateCommentOutputGateway;
        this.findCommentByIdOutputGateway = findCommentByIdOutputGateway;
    }

    public Optional<Comment> update(Comment comment) {
        if (!comment.isValid()) {
            throw new CommentNotValidException("Comment is not valid!");
        }

        Optional<Comment> foundComment = findCommentById(comment.getId());
        foundComment.ifPresent(updateCommentOutputGateway::update);
        return foundComment;
    }

    private Optional<Comment> findCommentById(Long id) {
        return Optional.ofNullable(findCommentByIdOutputGateway.findById(id)
                .orElseThrow(() -> new CommentNotFoundException("Comment not found!")));
    }
}
