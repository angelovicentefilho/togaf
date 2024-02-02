package br.com.jtech.services.togaf.core.application.usecases.comment;

import br.com.jtech.services.togaf.core.application.domains.Comment;
import br.com.jtech.services.togaf.core.application.exceptions.CommentNotFoundException;
import br.com.jtech.services.togaf.core.application.exceptions.CommentNotValidException;
import br.com.jtech.services.togaf.core.application.usecases.comment.ports.input.UpdateCommentInputGateway;
import br.com.jtech.services.togaf.core.application.usecases.comment.ports.output.FindCommentByIdOutputGateway;
import br.com.jtech.services.togaf.core.application.usecases.comment.ports.output.UpdateCommentOutputGateway;

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
