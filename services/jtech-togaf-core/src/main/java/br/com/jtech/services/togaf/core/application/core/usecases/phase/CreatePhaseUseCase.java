package br.com.jtech.services.togaf.core.application.core.usecases.phase;

import br.com.jtech.services.togaf.core.application.core.domains.Phase;
import br.com.jtech.services.togaf.core.application.ports.input.CreatePhaseInputGateway;
import br.com.jtech.services.togaf.core.application.ports.output.CreatePhaseOutputGateway;

import java.util.Optional;

public class CreatePhaseUseCase implements CreatePhaseInputGateway {

    private final CreatePhaseOutputGateway createPhaseOutputGateway;

    public CreatePhaseUseCase(final CreatePhaseOutputGateway createPhaseOutputGateway) {
        this.createPhaseOutputGateway = createPhaseOutputGateway;
    }

    @Override
    public Optional<Phase> create(Phase phase) {
        return createPhaseOutputGateway.create(phase);
    }

}
