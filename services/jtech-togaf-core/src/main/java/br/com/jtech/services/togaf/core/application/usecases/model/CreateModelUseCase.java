package br.com.jtech.services.togaf.core.application.usecases.model;

import br.com.jtech.services.togaf.core.application.domains.Model;
import br.com.jtech.services.togaf.core.application.usecases.model.ports.input.CreateModelInputGateway;
import br.com.jtech.services.togaf.core.application.usecases.model.ports.output.CreateModelOutputGateway;

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
