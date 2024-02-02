package br.com.jtech.services.togaf.core.application.usecases.model.ports.output;

import br.com.jtech.services.togaf.core.application.domains.Model;

import java.util.Optional;

public interface FindModelByNameOutputGateway {
    Optional<Model> findByName(String name);
}
