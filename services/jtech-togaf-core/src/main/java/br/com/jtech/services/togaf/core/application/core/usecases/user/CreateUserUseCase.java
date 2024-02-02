package br.com.jtech.services.togaf.core.application.core.usecases.user;

import br.com.jtech.services.togaf.core.application.core.domains.User;
import br.com.jtech.services.togaf.core.application.core.exceptions.UserAlreadyExistsException;
import br.com.jtech.services.togaf.core.application.core.exceptions.UserDataInvalidException;
import br.com.jtech.services.togaf.core.application.ports.input.CreateUserInputGateway;
import br.com.jtech.services.togaf.core.application.ports.output.CreateUserOutputGateway;
import br.com.jtech.services.togaf.core.application.ports.output.FindUserByEmailOutputGateway;

import java.util.Optional;

public class CreateUserUseCase implements CreateUserInputGateway {

    private final CreateUserOutputGateway createUserOutputGateway;
    private final FindUserByEmailOutputGateway findUserByEmailOutputGateway;

    public CreateUserUseCase(final CreateUserOutputGateway createUserOutputGateway,
                             final FindUserByEmailOutputGateway findUserByEmailOutputGateway) {
        this.createUserOutputGateway = createUserOutputGateway;
        this.findUserByEmailOutputGateway = findUserByEmailOutputGateway;
    }

    @Override
    public Optional<User> create(User user) {
        if (!user.isValid()) {
            throw new UserDataInvalidException("User with invalid data!");
        }

        if (userAlreadyExists(user.getEmail())) {
            throw new UserAlreadyExistsException("User with email '" + user.getEmail() + "' already exists.");
        }

        return createUserOutputGateway.create(user);
    }

    private boolean userAlreadyExists(String email) {
        return findUserByEmailOutputGateway.findByEmail(email).isPresent();
    }
}
