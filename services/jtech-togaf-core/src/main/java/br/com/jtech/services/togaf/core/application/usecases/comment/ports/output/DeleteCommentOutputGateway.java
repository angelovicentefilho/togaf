package br.com.jtech.services.togaf.core.application.usecases.comment.ports.output;

import br.com.jtech.services.togaf.core.application.domains.Comment;

public interface DeleteCommentOutputGateway {
    void delete(Comment comment);
}
