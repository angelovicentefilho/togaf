package br.com.jtech.services.togaf.core.application.core.usecases.project;

import br.com.jtech.services.togaf.core.application.core.domains.Project;
import br.com.jtech.services.togaf.core.application.core.exceptions.ProjectNotFoundException;
import br.com.jtech.services.togaf.core.application.ports.input.DeleteProjectByIdInputGateway;
import br.com.jtech.services.togaf.core.application.ports.output.DeleteProjectOuputGateway;
import br.com.jtech.services.togaf.core.application.ports.output.FindProjectByIdOutputGateway;

import java.util.Optional;

import static java.util.Objects.nonNull;

public class DeleteProjectByIdUseCase implements DeleteProjectByIdInputGateway {

    private final FindProjectByIdOutputGateway findProjectByIdOutputGateway;
    private final DeleteProjectOuputGateway deleteProjectOuputGateway;

    public DeleteProjectByIdUseCase(final FindProjectByIdOutputGateway findProjectByIdOutputGateway,
                                    final DeleteProjectOuputGateway deleteProjectOuputGateway) {
        this.findProjectByIdOutputGateway = findProjectByIdOutputGateway;
        this.deleteProjectOuputGateway = deleteProjectOuputGateway;
    }

    @Override
    public void delete(Long id) {
        if (nonNull(id)) {
            var projectFound = findProjectById(id);
            projectFound.ifPresent(deleteProjectOuputGateway::delete);
        }
        throw new ProjectNotFoundException("Project '" + id + "' not found!");
    }

    private Optional<Project> findProjectById(Long id) {
        return findProjectByIdOutputGateway.findById(id);
    }
}
