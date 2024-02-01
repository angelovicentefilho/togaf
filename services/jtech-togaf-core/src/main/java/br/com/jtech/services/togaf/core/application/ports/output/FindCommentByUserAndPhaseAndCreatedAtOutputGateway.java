package br.com.jtech.services.togaf.core.application.ports.output;

import br.com.jtech.services.togaf.core.application.core.domains.Comment;
import br.com.jtech.services.togaf.core.application.core.domains.Phase;
import br.com.jtech.services.togaf.core.application.core.domains.User;

import java.time.LocalDate;
import java.util.Optional;

public interface FindCommentByUserAndPhaseAndCreatedAtOutputGateway {
    Optional<Comment> findByUserAndPhaseAndCreateAt(User user, Phase phase, LocalDate createdAt);
}
