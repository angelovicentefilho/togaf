package br.com.jtech.services.togaf.core.application.usecases.model.ports.input;

import br.com.jtech.services.togaf.core.application.domains.Model;

import java.util.Optional;

public interface CreateModelInputGateway {
    Optional<Model> create(Model model);
}
