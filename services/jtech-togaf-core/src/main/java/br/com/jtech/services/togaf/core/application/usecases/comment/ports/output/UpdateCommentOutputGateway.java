package br.com.jtech.services.togaf.core.application.usecases.comment.ports.output;

import br.com.jtech.services.togaf.core.application.domains.Comment;

import java.util.Optional;

public interface UpdateCommentOutputGateway {
    Optional<Comment> update(Comment comment);
}
