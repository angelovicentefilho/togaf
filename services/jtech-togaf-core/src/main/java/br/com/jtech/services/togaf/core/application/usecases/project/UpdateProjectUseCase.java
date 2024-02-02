package br.com.jtech.services.togaf.core.application.usecases.project;

import br.com.jtech.services.togaf.core.application.domains.Project;
import br.com.jtech.services.togaf.core.application.exceptions.ProjectNotValidException;
import br.com.jtech.services.togaf.core.application.usecases.project.ports.input.UpdateProjectInputGateway;
import br.com.jtech.services.togaf.core.application.usecases.project.ports.output.UpdateProjectOutputGateway;

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
