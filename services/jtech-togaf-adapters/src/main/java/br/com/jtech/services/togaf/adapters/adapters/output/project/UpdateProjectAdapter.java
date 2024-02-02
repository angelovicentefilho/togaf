package br.com.jtech.services.togaf.adapters.adapters.output.project;

import br.com.jtech.services.togaf.adapters.adapters.output.project.repository.ProjectRepository;
import br.com.jtech.services.togaf.core.application.domains.Project;
import br.com.jtech.services.togaf.core.application.usecases.project.ports.output.UpdateProjectOutputGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static br.com.jtech.services.togaf.adapters.adapters.output.project.repository.entity.ProjectEntity.fromDomain;

@Service
@RequiredArgsConstructor
public class UpdateProjectAdapter implements UpdateProjectOutputGateway {

    private final ProjectRepository repository;

    @Override
    @CachePut(value = "project", key = "#project.id")
    public Optional<Project> update(Project project) {
        return Optional.of(repository.save(fromDomain(project)).toDomain());
    }
}
