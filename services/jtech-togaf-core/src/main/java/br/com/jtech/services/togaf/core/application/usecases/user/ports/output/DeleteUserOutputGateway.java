package br.com.jtech.services.togaf.core.application.usecases.user.ports.output;

import br.com.jtech.services.togaf.core.application.domains.User;

public interface DeleteUserOutputGateway {
    void delete(User user);
}
