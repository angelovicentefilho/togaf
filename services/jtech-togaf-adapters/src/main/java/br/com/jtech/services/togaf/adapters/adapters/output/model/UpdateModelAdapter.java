package br.com.jtech.services.togaf.adapters.adapters.output.model;

import br.com.jtech.services.togaf.adapters.adapters.output.model.repository.ModelRepository;
import br.com.jtech.services.togaf.core.application.domains.Model;
import br.com.jtech.services.togaf.core.application.usecases.model.ports.output.UpdateModelOutputGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static br.com.jtech.services.togaf.adapters.adapters.output.model.repository.entity.ModelEntity.fromDomain;

@Service
@RequiredArgsConstructor
public class UpdateModelAdapter implements UpdateModelOutputGateway {

    private final ModelRepository repository;

    @Override
    @CachePut(value = "model", key = "#model.id")
    public Optional<Model> update(Model model) {
        return Optional.of(repository.save(fromDomain(model)).toDomain());
    }
}
