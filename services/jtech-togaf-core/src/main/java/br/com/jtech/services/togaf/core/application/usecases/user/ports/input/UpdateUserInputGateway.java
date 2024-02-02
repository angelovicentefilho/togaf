package br.com.jtech.services.togaf.core.application.usecases.user.ports.input;

import br.com.jtech.services.togaf.core.application.domains.User;

import java.util.Optional;

public interface UpdateUserInputGateway {
    Optional<User> update(User user);
}
