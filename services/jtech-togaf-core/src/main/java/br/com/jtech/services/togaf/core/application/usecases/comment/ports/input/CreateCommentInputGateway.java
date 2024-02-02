package br.com.jtech.services.togaf.core.application.usecases.comment.ports.input;

import br.com.jtech.services.togaf.core.application.domains.Comment;

import java.util.Optional;

public interface CreateCommentInputGateway {
    Optional<Comment> create(Comment comment);
}
