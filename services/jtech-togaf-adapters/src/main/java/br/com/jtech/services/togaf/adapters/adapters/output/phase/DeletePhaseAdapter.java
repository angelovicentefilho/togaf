package br.com.jtech.services.togaf.adapters.adapters.output.phase;

import br.com.jtech.services.togaf.adapters.adapters.output.phase.repository.PhaseRepository;
import br.com.jtech.services.togaf.core.application.domains.Phase;
import br.com.jtech.services.togaf.core.application.usecases.phase.ports.output.DeletePhaseOutputGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeletePhaseAdapter implements DeletePhaseOutputGateway {

    private final PhaseRepository repository;

    @Override
    @CacheEvict(value = "phase", key = "#phase.id")
    public void delete(Phase phase) {
        repository.deleteById(phase.getId());
    }
}
