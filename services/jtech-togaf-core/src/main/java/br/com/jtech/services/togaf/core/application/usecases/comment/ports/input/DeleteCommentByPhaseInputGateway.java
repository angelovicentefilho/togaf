package br.com.jtech.services.togaf.core.application.usecases.comment.ports.input;

import br.com.jtech.services.togaf.core.application.domains.Comment;

public interface DeleteCommentByPhaseInputGateway {
    void delete(Comment comment);
}
