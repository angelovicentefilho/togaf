package br.com.jtech.services.togaf.core.application.ports.input;

import br.com.jtech.services.togaf.core.application.core.domains.Project;

import java.util.Optional;

public interface CreateProjectInputGateway {
    Optional<Project> create(Project project);
}
