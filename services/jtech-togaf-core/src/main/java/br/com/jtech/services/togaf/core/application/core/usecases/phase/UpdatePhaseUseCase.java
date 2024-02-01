package br.com.jtech.services.togaf.core.application.core.usecases.phase;

import br.com.jtech.services.togaf.core.application.core.domains.Phase;
import br.com.jtech.services.togaf.core.application.ports.output.UpdatePhaseOutputGateway;
import br.com.jtech.services.togaf.core.application.ports.input.UpdatePhaseInputGateway;

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
