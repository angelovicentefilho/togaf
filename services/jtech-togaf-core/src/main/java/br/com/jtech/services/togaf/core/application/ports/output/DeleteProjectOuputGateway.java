package br.com.jtech.services.togaf.core.application.ports.output;

import br.com.jtech.services.togaf.core.application.core.domains.Project;

public interface DeleteProjectOuputGateway {
    void delete(Project project);
}
