package br.com.jtech.services.togaf.core.application.usecases.model;

import br.com.jtech.services.togaf.core.application.domains.Model;
import br.com.jtech.services.togaf.core.application.exceptions.ModelNotFoundException;
import br.com.jtech.services.togaf.core.application.usecases.model.ports.input.DeleteModelByNameInputGateway;
import br.com.jtech.services.togaf.core.application.usecases.model.ports.output.DeleteModelOutputGateway;
import br.com.jtech.services.togaf.core.application.usecases.model.ports.output.FindModelByNameOutputGateway;

import static java.util.Objects.nonNull;

public class DeleteModelByNameUseCase implements DeleteModelByNameInputGateway {

    private final DeleteModelOutputGateway deleteModelOutputGateway;
    private final FindModelByNameOutputGateway findModelByNameOutputGateway;

    public DeleteModelByNameUseCase(final DeleteModelOutputGateway deleteModelOutputGateway,
                                    final FindModelByNameOutputGateway findModelByNameOutputGateway) {
        this.deleteModelOutputGateway = deleteModelOutputGateway;
        this.findModelByNameOutputGateway = findModelByNameOutputGateway;
    }

    @Override
    public void delete(String name) {
        var foundModel = findModelByName(name);
        if (nonNull(foundModel))
            deleteModelOutputGateway.delete(foundModel);

    }


    private Model findModelByName(String name) {
        return this.findModelByNameOutputGateway.findByName(name).orElseThrow(() -> {
            throw new ModelNotFoundException("Model '" + name + "' not found!");
        });
    }

    private boolean hasName(String name) {
        return nonNull(name) && !name.isEmpty();
    }

}
