package br.com.jtech.services.togaf.core.application.core.usecases.user;

import br.com.jtech.services.togaf.core.application.core.domains.User;
import br.com.jtech.services.togaf.core.application.core.exceptions.UserNotValidException;
import br.com.jtech.services.togaf.core.application.ports.input.UpdateUserInputGateway;
import br.com.jtech.services.togaf.core.application.ports.output.UpdateUserOutputGateway;

import java.util.Optional;

import static java.util.Objects.nonNull;

public class UpdateUserUseCase implements UpdateUserInputGateway {

    private final UpdateUserOutputGateway updateUserOutputGateway;

    public UpdateUserUseCase(final UpdateUserOutputGateway updateUserOutputGateway) {
        this.updateUserOutputGateway = updateUserOutputGateway;
    }

    @Override
    public Optional<User> update(User user) {
        if (nonNull(user) && user.isValid()) {
            return updateUserOutputGateway.update(user);
        } else
            throw new UserNotValidException("User not is valid!");
    }
}
