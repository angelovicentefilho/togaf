package br.com.jtech.services.togaf.adapters.adapters.output.project;

import br.com.jtech.services.togaf.adapters.adapters.output.project.repository.ProjectRepository;
import br.com.jtech.services.togaf.core.application.domains.Project;
import br.com.jtech.services.togaf.core.application.usecases.project.ports.output.CreateProjectOutputGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static br.com.jtech.services.togaf.adapters.adapters.output.project.repository.entity.ProjectEntity.fromDomain;

@Service
@RequiredArgsConstructor
public class CreateProjectAdapter implements CreateProjectOutputGateway {

    private final ProjectRepository repository;

    @Override
    @CachePut(value = "project", key = "#project.id")
    public Optional<Project> create(Project project) {
        return Optional.of(this.repository.save(fromDomain(project)).toDomain());
    }
}
