package br.com.jtech.services.togaf.core.application.ports.output;

import br.com.jtech.services.togaf.core.application.core.domains.Phase;

public interface DeletePhaseOutputGateway {
    void delete(Phase phase);
}
