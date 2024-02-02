package br.com.jtech.services.togaf.core.application.usecases.model;

import br.com.jtech.services.togaf.core.application.domains.Model;
import br.com.jtech.services.togaf.core.application.domains.Phase;
import br.com.jtech.services.togaf.core.application.exceptions.ModelNotFoundException;
import br.com.jtech.services.togaf.core.application.usecases.model.ports.input.AddPhasesToModelInputGateway;
import br.com.jtech.services.togaf.core.application.usecases.model.ports.output.FindModelByNameOutputGateway;
import br.com.jtech.services.togaf.core.application.usecases.model.ports.output.UpdateModelOutputGateway;

import java.util.Optional;
import java.util.Set;

public class AddPhasesToModelUseCase implements AddPhasesToModelInputGateway {

    private final FindModelByNameOutputGateway findModelByNameOutputGateway;
    private final UpdateModelOutputGateway updateModelOutputGateway;

    public AddPhasesToModelUseCase(final FindModelByNameOutputGateway findModelByNameOutputGateway,
                                   final UpdateModelOutputGateway updateModelOutputGateway) {
        this.findModelByNameOutputGateway = findModelByNameOutputGateway;
        this.updateModelOutputGateway = updateModelOutputGateway;
    }

    @Override
    public Optional<Model> addOrUpdateModelWithPhases(Model model) {
        if (model.hasPhases()) {
            var foundModel = findModelByName(model.getName());
            if (foundModel.isPresent()) {
                updateModelPhases(foundModel.get(), model.getPhases());
                return updateModel(foundModel.get());
            }
        }
        throw new ModelNotFoundException("Model '" + model.getName() + "' not found.");
    }

    private Optional<Model> updateModel(Model model) {
        return updateModelOutputGateway.update(model);
    }

    private Optional<Model> findModelByName(String name) {
        return findModelByNameOutputGateway.findByName(name);
    }

    private void updateModelPhases(Model existingModel, Set<Phase> newPhases) {
        existingModel.setPhases(newPhases);
    }
}
