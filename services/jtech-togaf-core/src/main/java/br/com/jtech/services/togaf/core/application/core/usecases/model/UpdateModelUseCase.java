package br.com.jtech.services.togaf.core.application.core.usecases.model;

import br.com.jtech.services.togaf.core.application.core.domains.Model;
import br.com.jtech.services.togaf.core.application.ports.input.UpdateModelInputGateway;
import br.com.jtech.services.togaf.core.application.ports.output.UpdateModelOutputGateway;

import java.util.Optional;

public class UpdateModelUseCase implements UpdateModelInputGateway {

    private final UpdateModelOutputGateway updateModelOutputGateway;

    public UpdateModelUseCase(final UpdateModelOutputGateway updateModelOutputGateway) {
        this.updateModelOutputGateway = updateModelOutputGateway;
    }

    @Override
    public Optional<Model> update(Model model) {
        return updateModelOutputGateway.update(model);
    }

}
