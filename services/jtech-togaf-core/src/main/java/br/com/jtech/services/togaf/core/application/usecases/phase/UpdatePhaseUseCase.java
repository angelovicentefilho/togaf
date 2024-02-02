package br.com.jtech.services.togaf.core.application.usecases.phase;

import br.com.jtech.services.togaf.core.application.domains.Phase;
import br.com.jtech.services.togaf.core.application.usecases.phase.ports.output.UpdatePhaseOutputGateway;
import br.com.jtech.services.togaf.core.application.usecases.phase.ports.input.UpdatePhaseInputGateway;

import java.util.Optional;

public class UpdatePhaseUseCase implements UpdatePhaseInputGateway {

    private final UpdatePhaseOutputGateway updatePhaseOutputGateway;

    public UpdatePhaseUseCase(final UpdatePhaseOutputGateway updatePhaseOutputGateway) {
        this.updatePhaseOutputGateway = updatePhaseOutputGateway;
    }

    @Override
    public Optional<Phase> update(Phase phase) {
        return this.updatePhaseOutputGateway.update(phase);
    }

}
