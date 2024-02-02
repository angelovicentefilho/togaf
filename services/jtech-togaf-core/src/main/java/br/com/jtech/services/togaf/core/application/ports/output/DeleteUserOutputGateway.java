package br.com.jtech.services.togaf.core.application.ports.output;

import br.com.jtech.services.togaf.core.application.core.domains.User;

import java.util.Optional;

public interface DeleteUserOutputGateway {
    void delete(User user);
}
