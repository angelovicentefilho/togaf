package br.com.jtech.services.togaf.adapters.adapters.output.project;

import br.com.jtech.services.togaf.adapters.adapters.output.project.repository.ProjectRepository;
import br.com.jtech.services.togaf.core.application.domains.Project;
import br.com.jtech.services.togaf.core.application.usecases.project.ports.output.DeleteProjectOuputGateway;
import jakarta.persistence.Cacheable;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteProjectAdapter implements DeleteProjectOuputGateway {

    private final ProjectRepository repository;

    @Override
    @CacheEvict(value = "project", key = "#project.id")
    public void delete(Project project) {
        this.repository.deleteById(project.getId());
    }
}
