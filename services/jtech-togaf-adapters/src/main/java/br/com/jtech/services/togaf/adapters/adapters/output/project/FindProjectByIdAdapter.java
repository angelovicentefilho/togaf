package br.com.jtech.services.togaf.adapters.adapters.output.project;

import br.com.jtech.services.togaf.adapters.adapters.output.project.repository.ProjectRepository;
import br.com.jtech.services.togaf.adapters.adapters.output.project.repository.entity.ProjectEntity;
import br.com.jtech.services.togaf.core.application.domains.Project;
import br.com.jtech.services.togaf.core.application.usecases.project.ports.output.FindProjectByIdOutputGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FindProjectByIdAdapter implements FindProjectByIdOutputGateway {

    private final ProjectRepository repository;

    @Override
    @Cacheable(value = "project", key = "#id")
    public Optional<Project> findById(Long id) {
        return repository.findById(id).map(ProjectEntity::toDomain);
    }
}
