package br.com.jtech.services.togaf.core.application.usecases.phase.ports.output;

import br.com.jtech.services.togaf.core.application.domains.Phase;

import java.util.Optional;

public interface UpdatePhaseOutputGateway {
    Optional<Phase> update(Phase phase);
}
