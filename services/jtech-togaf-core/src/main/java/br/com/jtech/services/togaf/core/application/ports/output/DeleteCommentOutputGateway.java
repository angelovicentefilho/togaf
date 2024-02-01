package br.com.jtech.services.togaf.core.application.ports.output;

import br.com.jtech.services.togaf.core.application.core.domains.Comment;

public interface DeleteCommentOutputGateway {
    void delete(Comment comment);
}
