package br.com.jtech.services.togaf.core.application.usecases.user;

import br.com.jtech.services.togaf.core.application.domains.User;
import br.com.jtech.services.togaf.core.application.exceptions.UserNotFoundException;
import br.com.jtech.services.togaf.core.application.usecases.user.ports.input.DeleteUserByEmailInputGateway;
import br.com.jtech.services.togaf.core.application.usecases.user.ports.output.DeleteUserOutputGateway;
import br.com.jtech.services.togaf.core.application.usecases.user.ports.output.FindUserByEmailOutputGateway;

import java.util.Optional;

import static java.util.Objects.nonNull;

public class DeleteUserByEmailUseCase implements DeleteUserByEmailInputGateway {

    private final FindUserByEmailOutputGateway findUserByEmailOutputGateway;
    private final DeleteUserOutputGateway deleteUserOutputGateway;

    public DeleteUserByEmailUseCase(final FindUserByEmailOutputGateway findUserByEmailOutputGateway,
                                    final DeleteUserOutputGateway deleteUserOutputGateway) {
        this.findUserByEmailOutputGateway = findUserByEmailOutputGateway;
        this.deleteUserOutputGateway = deleteUserOutputGateway;
    }

    @Override
    public void delete(String email) {
        if (nonNull(email)) {
            var userFound = Optional.of(findByEmail(email));
            userFound.ifPresent(deleteUserOutputGateway::delete);
        } else
            throw new UserNotFoundException("Email not found!");

    }

    private User findByEmail(String email) {
        return findUserByEmailOutputGateway.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("User with email '" + email + "' not found!"));
    }
}
