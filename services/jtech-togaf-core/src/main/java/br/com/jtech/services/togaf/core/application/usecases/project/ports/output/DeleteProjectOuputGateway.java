package br.com.jtech.services.togaf.core.application.usecases.project.ports.output;

import br.com.jtech.services.togaf.core.application.domains.Project;

public interface DeleteProjectOuputGateway {
    void delete(Project project);
}
