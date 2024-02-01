package br.com.jtech.services.togaf.core.application.ports.output;

import br.com.jtech.services.togaf.core.application.core.domains.Model;

import java.util.Optional;

public interface FindModelByNameOutputGateway {
    Optional<Model> findByName(String name);
}
