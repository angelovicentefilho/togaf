package br.com.jtech.services.togaf.core.application.usecases.user.ports.input;

public interface DeleteUserByEmailInputGateway {
    void delete(String email);
}
