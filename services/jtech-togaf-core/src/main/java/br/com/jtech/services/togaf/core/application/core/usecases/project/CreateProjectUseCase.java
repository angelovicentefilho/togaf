package br.com.jtech.services.togaf.core.application.core.usecases.project;

import br.com.jtech.services.togaf.core.application.core.domains.Project;
import br.com.jtech.services.togaf.core.application.ports.input.CreateProjectInputGateway;
import br.com.jtech.services.togaf.core.application.ports.output.CreateProjectOutputGateway;

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
