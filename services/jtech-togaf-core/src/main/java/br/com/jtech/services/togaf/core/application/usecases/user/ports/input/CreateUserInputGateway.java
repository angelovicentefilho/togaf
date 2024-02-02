package br.com.jtech.services.togaf.core.application.usecases.user.ports.input;

import br.com.jtech.services.togaf.core.application.domains.User;

import java.util.Optional;

public interface CreateUserInputGateway {
    Optional<User> create(User user);
}
