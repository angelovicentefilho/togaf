package br.com.jtech.services.togaf.core.application.ports.input;

import br.com.jtech.services.togaf.core.application.core.domains.Comment;

import java.util.Optional;

public interface CreateCommentInputGateway {
    Optional<Comment> create(Comment comment);
}
