package br.com.jtech.services.togaf.core.application.ports.input;

import br.com.jtech.services.togaf.core.application.core.domains.User;

import java.util.Optional;

public interface UpdateUserInputGateway {
    Optional<User> update(User user);
}
