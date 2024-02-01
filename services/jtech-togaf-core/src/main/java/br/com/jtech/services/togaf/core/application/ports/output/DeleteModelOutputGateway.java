package br.com.jtech.services.togaf.core.application.ports.output;

import br.com.jtech.services.togaf.core.application.core.domains.Model;

public interface DeleteModelOutputGateway {
    void delete(Model model);
}
