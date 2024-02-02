package br.com.jtech.services.togaf.core.application.usecases.model.ports.output;

import br.com.jtech.services.togaf.core.application.domains.Model;

public interface DeleteModelOutputGateway {
    void delete(Model model);
}
