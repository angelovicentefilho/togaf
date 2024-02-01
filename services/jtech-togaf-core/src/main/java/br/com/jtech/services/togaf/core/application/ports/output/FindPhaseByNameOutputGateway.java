package br.com.jtech.services.togaf.core.application.ports.output;

import br.com.jtech.services.togaf.core.application.core.domains.Phase;

import java.util.Optional;

public interface FindPhaseByNameOutputGateway {
    Optional<Phase> findByName(String name);
}
