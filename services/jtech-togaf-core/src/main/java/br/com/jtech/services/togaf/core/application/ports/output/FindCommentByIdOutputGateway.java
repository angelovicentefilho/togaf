package br.com.jtech.services.togaf.core.application.ports.output;

import br.com.jtech.services.togaf.core.application.core.domains.Comment;

import java.util.Optional;

public interface FindCommentByIdOutputGateway {
    Optional<Comment> findById(Long id);
}
