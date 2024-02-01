package br.com.jtech.services.togaf.core.application.ports.input;

import br.com.jtech.services.togaf.core.application.core.domains.Comment;

public interface DeleteCommentByPhaseInputGateway {
    void delete(Comment comment);
}
