package br.com.jtech.services.togaf.adapters.adapters.output.model;

import br.com.jtech.services.togaf.adapters.adapters.output.model.repository.ModelRepository;
import br.com.jtech.services.togaf.core.application.domains.Model;
import br.com.jtech.services.togaf.core.application.usecases.model.ports.output.DeleteModelOutputGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteModelAdapter implements DeleteModelOutputGateway {

    private final ModelRepository repository;

    @Override
    @CacheEvict(value = "model", key = "#model.id")
    public void delete(Model model) {
        repository.deleteById(model.getId());
    }
}
