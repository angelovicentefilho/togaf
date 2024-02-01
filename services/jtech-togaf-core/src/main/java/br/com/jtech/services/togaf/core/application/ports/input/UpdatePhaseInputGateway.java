package br.com.jtech.services.togaf.core.application.ports.input;

import br.com.jtech.services.togaf.core.application.core.domains.Phase;

import java.util.Optional;

public interface UpdatePhaseInputGateway {
    Optional<Phase> update(Phase phase);
}
