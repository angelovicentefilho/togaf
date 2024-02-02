package br.com.jtech.services.togaf.core.application.usecases.phase.ports.input;

import br.com.jtech.services.togaf.core.application.domains.Phase;

import java.util.Optional;

public interface UpdatePhaseInputGateway {
    Optional<Phase> update(Phase phase);
}
