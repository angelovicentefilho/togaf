package br.com.jtech.services.togaf.core.application.usecases.phase;

import br.com.jtech.services.togaf.core.application.domains.Phase;
import br.com.jtech.services.togaf.core.application.exceptions.PhaseNotFoundException;
import br.com.jtech.services.togaf.core.application.usecases.phase.ports.input.DeletePhaseByNameInputGateway;
import br.com.jtech.services.togaf.core.application.usecases.phase.ports.output.DeletePhaseOutputGateway;
import br.com.jtech.services.togaf.core.application.usecases.phase.ports.output.FindPhaseByNameOutputGateway;

import java.util.Optional;

import static br.com.jtech.services.togaf.core.application.utils.Strings.hasText;

public class DeletePhaseByNameUseCase implements DeletePhaseByNameInputGateway {

    private final FindPhaseByNameOutputGateway findPhaseByNameOutputGateway;
    private final DeletePhaseOutputGateway deletePhaseOutputGateway;

    public DeletePhaseByNameUseCase(final FindPhaseByNameOutputGateway findPhaseByNameOutputGateway,
                                    final DeletePhaseOutputGateway deletePhaseOutputGateway) {
        this.findPhaseByNameOutputGateway = findPhaseByNameOutputGateway;
        this.deletePhaseOutputGateway = deletePhaseOutputGateway;
    }

    @Override
    public void delete(String name) {
        if (hasText(name)) {
            Optional<Phase> phase = Optional.of(findPhaseByName(name));
            phase.ifPresent(deletePhaseOutputGateway::delete);
        } else
            throw new PhaseNotFoundException("Phase '" + name + "' not found!");
    }


    private Phase findPhaseByName(String name) {
        return findPhaseByNameOutputGateway.findByName(name)
                .orElseThrow(() -> new PhaseNotFoundException("Phase '" + name + "' not found!"));
    }
}
