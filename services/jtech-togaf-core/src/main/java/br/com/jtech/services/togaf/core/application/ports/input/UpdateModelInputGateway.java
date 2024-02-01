package br.com.jtech.services.togaf.core.application.ports.input;

import br.com.jtech.services.togaf.core.application.core.domains.Model;

import java.util.Optional;

public interface UpdateModelInputGateway {
    Optional<Model> update(Model model);
}
