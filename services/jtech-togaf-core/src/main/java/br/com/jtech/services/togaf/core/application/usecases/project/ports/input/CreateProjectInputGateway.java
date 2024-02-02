package br.com.jtech.services.togaf.core.application.usecases.project.ports.input;

import br.com.jtech.services.togaf.core.application.domains.Project;

import java.util.Optional;

public interface CreateProjectInputGateway {
    Optional<Project> create(Project project);
}
