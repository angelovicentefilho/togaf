package br.com.jtech.services.togaf.core.application.usecases.phase;

import br.com.jtech.services.togaf.core.application.domains.Phase;
import br.com.jtech.services.togaf.core.application.exceptions.PhaseNotFoundException;
import br.com.jtech.services.togaf.core.application.usecases.phase.ports.input.DeletePhaseByIdInputGateway;
import br.com.jtech.services.togaf.core.application.usecases.phase.ports.output.DeletePhaseOutputGateway;
import br.com.jtech.services.togaf.core.application.usecases.phase.ports.output.FindPhaseByIdOutputGateway;

import java.util.Optional;

import static java.util.Objects.nonNull;

public class DeletePhaseByIdUseCase implements DeletePhaseByIdInputGateway {

    private final FindPhaseByIdOutputGateway findPhaseByIdOutputGateway;
    private final DeletePhaseOutputGateway deletePhaseOutputGateway;

    public DeletePhaseByIdUseCase(final FindPhaseByIdOutputGateway findPhaseByIdOutputGateway,
                                  final DeletePhaseOutputGateway deletePhaseOutputGateway) {
        this.findPhaseByIdOutputGateway = findPhaseByIdOutputGateway;
        this.deletePhaseOutputGateway = deletePhaseOutputGateway;
    }

    @Override
    public void delete(Long id) {
        if (nonNull(id)) {
            Optional<Phase> phase = Optional.of(findPhaseById(id));
            phase.ifPresent(deletePhaseOutputGateway::delete);
        } else {
            throw new PhaseNotFoundException("Phase '" + id + "' not found!");
        }
    }

    private Phase findPhaseById(Long id) {
        return findPhaseByIdOutputGateway.findById(id)
                .orElseThrow(() -> new PhaseNotFoundException("Phase '" + id + "' not found!"));
    }

}
