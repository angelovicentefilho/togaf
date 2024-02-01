package br.com.jtech.services.togaf.core.application.core.usecases.model;

import br.com.jtech.services.togaf.core.application.core.domains.Model;
import br.com.jtech.services.togaf.core.application.ports.input.CreateModelInputGateway;
import br.com.jtech.services.togaf.core.application.ports.output.CreateModelOutputGateway;

import java.util.Optional;

public class CreateModelUseCase implements CreateModelInputGateway {

    private final CreateModelOutputGateway createModelOutputGateway;

    public CreateModelUseCase(CreateModelOutputGateway createModelOutputGateway) {
        this.createModelOutputGateway = createModelOutputGateway;
    }

    @Override
    public Optional<Model> create(Model model) {
        return createModelOutputGateway.create(model);
    }

}
