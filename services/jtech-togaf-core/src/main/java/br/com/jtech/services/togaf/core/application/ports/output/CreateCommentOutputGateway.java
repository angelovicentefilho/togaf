package br.com.jtech.services.togaf.core.application.ports.output;

import br.com.jtech.services.togaf.core.application.core.domains.Comment;

import java.util.Optional;

public interface CreateCommentOutputGateway {
    Optional<Comment> create(Comment comment);
}
