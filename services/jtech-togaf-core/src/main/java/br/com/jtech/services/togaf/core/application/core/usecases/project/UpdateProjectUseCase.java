package br.com.jtech.services.togaf.core.application.core.usecases.project;

import br.com.jtech.services.togaf.core.application.core.domains.Project;
import br.com.jtech.services.togaf.core.application.core.exceptions.ProjectNotValidException;
import br.com.jtech.services.togaf.core.application.ports.input.UpdateProjectInputGateway;
import br.com.jtech.services.togaf.core.application.ports.output.UpdateProjectOutputGateway;

import java.util.Optional;

import static java.util.Objects.nonNull;

public class UpdateProjectUseCase implements UpdateProjectInputGateway {

    private final UpdateProjectOutputGateway updateProjectOutputGateway;

    public UpdateProjectUseCase(final UpdateProjectOutputGateway updateProjectOutputGateway) {
        this.updateProjectOutputGateway = updateProjectOutputGateway;
    }

    @Override
    public Optional<Project> update(Project project) {
        if (nonNull(project) && project.isValid()) {
            return this.updateProjectOutputGateway.update(project);
        } else
            throw new ProjectNotValidException("Project '" + (nonNull(project) ? project.getId() : null) + "' not valid!");
    }

}
