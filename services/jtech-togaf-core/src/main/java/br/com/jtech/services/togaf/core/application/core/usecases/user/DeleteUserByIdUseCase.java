package br.com.jtech.services.togaf.core.application.core.usecases.user;

import br.com.jtech.services.togaf.core.application.core.domains.User;
import br.com.jtech.services.togaf.core.application.core.exceptions.UserNotFoundException;
import br.com.jtech.services.togaf.core.application.ports.input.DeleteUserByIdInputGateway;
import br.com.jtech.services.togaf.core.application.ports.output.DeleteUserOutputGateway;
import br.com.jtech.services.togaf.core.application.ports.output.FindUserByIdOutputGateway;

import java.util.Optional;

import static java.util.Objects.nonNull;

public class DeleteUserByIdUseCase implements DeleteUserByIdInputGateway {

    private final FindUserByIdOutputGateway findUserByIdOutputGateway;
    private final DeleteUserOutputGateway deleteUserOutputGateway;

    public DeleteUserByIdUseCase(final FindUserByIdOutputGateway findUserByIdOutputGateway,
                                 final DeleteUserOutputGateway deleteUserOutputGateway) {
        this.findUserByIdOutputGateway = findUserByIdOutputGateway;
        this.deleteUserOutputGateway = deleteUserOutputGateway;
    }

    @Override
    public void delete(Long id) {
        if (nonNull(id)) {
            var userFound = Optional.of(findById(id));
            userFound.ifPresent(deleteUserOutputGateway::delete);
        } else
            throw new UserNotFoundException("Id not found!");
    }

    private User findById(Long id) {
        return this.findUserByIdOutputGateway.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User with id '" + id + "' not found!"));
    }
}
