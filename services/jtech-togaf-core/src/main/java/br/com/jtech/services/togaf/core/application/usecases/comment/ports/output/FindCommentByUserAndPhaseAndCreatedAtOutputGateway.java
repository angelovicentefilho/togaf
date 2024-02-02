package br.com.jtech.services.togaf.core.application.usecases.comment.ports.output;

import br.com.jtech.services.togaf.core.application.domains.Comment;
import br.com.jtech.services.togaf.core.application.domains.Phase;
import br.com.jtech.services.togaf.core.application.domains.User;

import java.time.LocalDate;
import java.util.Optional;

public interface FindCommentByUserAndPhaseAndCreatedAtOutputGateway {
    Optional<Comment> findByUserAndPhaseAndCreateAt(User user, Phase phase, LocalDate createdAt);
}
