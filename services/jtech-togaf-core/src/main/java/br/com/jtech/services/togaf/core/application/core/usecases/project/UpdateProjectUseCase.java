package br.com.jtech.services.togaf.core.application.core.usecases.project;

import br.com.jtech.services.togaf.core.application.core.domains.Project;
import br.com.jtech.services.togaf.core.application.ports.input.UpdateProjectInputGateway;
import br.com.jtech.services.togaf.core.application.ports.output.UpdateProjectOutputGateway;

import java.util.Optional;

public class UpdateProjectUseCase implements UpdateProjectInputGateway {

    private final UpdateProjectOutputGateway updateProjectOutputGateway;

    public UpdateProjectUseCase(final UpdateProjectOutputGateway updateProjectOutputGateway) {
        this.updateProjectOutputGateway = updateProjectOutputGateway;
    }

    @Override
    public Optional<Project> udpate(Project project) {
        return this.updateProjectOutputGateway.update(project);
    }

}
