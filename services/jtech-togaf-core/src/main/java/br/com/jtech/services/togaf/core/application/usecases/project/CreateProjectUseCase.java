package br.com.jtech.services.togaf.core.application.usecases.project;

import br.com.jtech.services.togaf.core.application.domains.Project;
import br.com.jtech.services.togaf.core.application.usecases.project.ports.input.CreateProjectInputGateway;
import br.com.jtech.services.togaf.core.application.usecases.project.ports.output.CreateProjectOutputGateway;

import java.util.Optional;

public class CreateProjectUseCase implements CreateProjectInputGateway {

    private final CreateProjectOutputGateway createProjectOutputGateway;

    public CreateProjectUseCase(final CreateProjectOutputGateway createProjectOutputGateway) {
        this.createProjectOutputGateway = createProjectOutputGateway;
    }

    @Override
    public Optional<Project> create(Project project) {
        return this.createProjectOutputGateway.create(project);
    }
}
