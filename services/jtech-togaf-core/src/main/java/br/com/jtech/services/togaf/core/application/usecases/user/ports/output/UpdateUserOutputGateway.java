package br.com.jtech.services.togaf.core.application.usecases.user.ports.output;

import br.com.jtech.services.togaf.core.application.domains.User;

import java.util.Optional;

public interface UpdateUserOutputGateway {
    Optional<User> update(User user);
}
