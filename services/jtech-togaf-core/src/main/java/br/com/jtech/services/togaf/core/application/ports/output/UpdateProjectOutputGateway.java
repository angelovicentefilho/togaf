package br.com.jtech.services.togaf.core.application.ports.output;

import br.com.jtech.services.togaf.core.application.core.domains.Project;

import java.util.Optional;

public interface UpdateProjectOutputGateway {
    Optional<Project> update(Project project);
}