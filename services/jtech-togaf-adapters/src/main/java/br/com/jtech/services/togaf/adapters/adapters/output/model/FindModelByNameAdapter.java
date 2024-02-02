package br.com.jtech.services.togaf.adapters.adapters.output.model;

import br.com.jtech.services.togaf.adapters.adapters.output.model.repository.ModelRepository;
import br.com.jtech.services.togaf.adapters.adapters.output.model.repository.entity.ModelEntity;
import br.com.jtech.services.togaf.core.application.domains.Model;
import br.com.jtech.services.togaf.core.application.usecases.model.ports.output.FindModelByNameOutputGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FindModelByNameAdapter implements FindModelByNameOutputGateway {

    private final ModelRepository repository;

    @Override
    @Cacheable(value = "model", key = "#name")
    public Optional<Model> findByName(String name) {
        return repository.findByName(name).map(ModelEntity::toDomain);
    }
}
