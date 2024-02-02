package br.com.jtech.services.togaf.core.application.usecases.phase;

import br.com.jtech.services.togaf.core.application.domains.Phase;
import br.com.jtech.services.togaf.core.application.usecases.phase.ports.input.CreatePhaseInputGateway;
import br.com.jtech.services.togaf.core.application.usecases.phase.ports.output.CreatePhaseOutputGateway;

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
