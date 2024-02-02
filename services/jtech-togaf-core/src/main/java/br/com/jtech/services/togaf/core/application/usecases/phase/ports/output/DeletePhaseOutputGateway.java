package br.com.jtech.services.togaf.core.application.usecases.phase.ports.output;

import br.com.jtech.services.togaf.core.application.domains.Phase;

public interface DeletePhaseOutputGateway {
    void delete(Phase phase);
}
