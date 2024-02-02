package br.com.jtech.services.togaf.core.application.usecases.project;

import br.com.jtech.services.togaf.core.application.domains.Project;
import br.com.jtech.services.togaf.core.application.exceptions.ProjectNotFoundException;
import br.com.jtech.services.togaf.core.application.usecases.project.ports.input.DeleteProjectByIdInputGateway;
import br.com.jtech.services.togaf.core.application.usecases.project.ports.output.DeleteProjectOuputGateway;
import br.com.jtech.services.togaf.core.application.usecases.project.ports.output.FindProjectByIdOutputGateway;

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
            var projectFound = Optional.of(findProjectById(id));
            projectFound.ifPresent(deleteProjectOuputGateway::delete);
        } else
            throw new ProjectNotFoundException("Project '" + id + "' not found!");
    }

    private Project findProjectById(Long id) {
        return findProjectByIdOutputGateway.findById(id)
                .orElseThrow(() -> new ProjectNotFoundException("Project '" + id + "' not found!"));
    }
}
