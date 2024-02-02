package br.com.jtech.services.togaf.adapters.adapters.output.phase;

import br.com.jtech.services.togaf.adapters.adapters.output.phase.repository.PhaseRepository;
import br.com.jtech.services.togaf.adapters.adapters.output.phase.repository.entity.PhaseEntity;
import br.com.jtech.services.togaf.core.application.domains.Phase;
import br.com.jtech.services.togaf.core.application.usecases.phase.ports.output.FindPhaseByIdOutputGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FindPhaseByIdAdapter implements FindPhaseByIdOutputGateway {

    private final PhaseRepository repository;

    @Override
    @Cacheable(value = "phase", key = "#id")
    public Optional<Phase> findById(Long id) {
        return repository.findById(id).map(PhaseEntity::toDomain);
    }
}
