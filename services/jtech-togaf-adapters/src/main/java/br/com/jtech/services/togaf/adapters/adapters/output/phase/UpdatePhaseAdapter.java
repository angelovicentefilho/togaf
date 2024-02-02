package br.com.jtech.services.togaf.adapters.adapters.output.phase;

import br.com.jtech.services.togaf.adapters.adapters.output.phase.repository.PhaseRepository;
import br.com.jtech.services.togaf.core.application.domains.Phase;
import br.com.jtech.services.togaf.core.application.usecases.phase.ports.output.UpdatePhaseOutputGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static br.com.jtech.services.togaf.adapters.adapters.output.phase.repository.entity.PhaseEntity.fromDomain;

@Service
@RequiredArgsConstructor
public class UpdatePhaseAdapter implements UpdatePhaseOutputGateway {

    private final PhaseRepository repository;

    @Override
    @CachePut(value = "phase", key = "#phase.id")
    public Optional<Phase> update(Phase phase) {
        return Optional.of(repository.save(fromDomain(phase)).toDomain());
    }
}
