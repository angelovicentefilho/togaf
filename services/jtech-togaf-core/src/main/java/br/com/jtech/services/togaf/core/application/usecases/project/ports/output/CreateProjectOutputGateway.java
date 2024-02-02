package br.com.jtech.services.togaf.core.application.usecases.project.ports.output;

import br.com.jtech.services.togaf.core.application.domains.Project;

import java.util.Optional;

public interface CreateProjectOutputGateway {
    Optional<Project> create(Project project);
}
