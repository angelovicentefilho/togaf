package br.com.jtech.services.togaf.core.application.core.usecases.user;

import br.com.jtech.services.togaf.core.application.core.domains.User;
import br.com.jtech.services.togaf.core.application.core.exceptions.UserNotFoundException;
import br.com.jtech.services.togaf.core.application.ports.input.DeleteUserByEmailInputGateway;
import br.com.jtech.services.togaf.core.application.ports.output.DeleteUserOutputGateway;
import br.com.jtech.services.togaf.core.application.ports.output.FindUserByEmailOutputGateway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class DeleteUserByEmailUseCaseTest {

    @Mock
    private FindUserByEmailOutputGateway findUserByEmailOutputGateway;

    @Mock
    private DeleteUserOutputGateway deleteUserOutputGateway;

    private DeleteUserByEmailInputGateway deleteUserByEmailUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        deleteUserByEmailUseCase = new DeleteUserByEmailUseCase(findUserByEmailOutputGateway, deleteUserOutputGateway);
    }

    @Test
    void delete_ExistingUser_UserDeleted() {
        // Arrange
        String email = "test@example.com";
        User user = new User();
        user.setEmail(email);

        when(findUserByEmailOutputGateway.findByEmail(email)).thenReturn(Optional.of(user));

        // Act
        assertDoesNotThrow(() -> deleteUserByEmailUseCase.delete(email));

        // Assert
        verify(findUserByEmailOutputGateway, times(1)).findByEmail(email);
        verify(deleteUserOutputGateway, times(1)).delete(user);
    }

    @Test
    void delete_NonExistingUser_ThrowsUserNotFoundException() {
        // Arrange
        String email = "test@example.com";

        when(findUserByEmailOutputGateway.findByEmail(email)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(UserNotFoundException.class, () -> deleteUserByEmailUseCase.delete(email));
        verify(findUserByEmailOutputGateway, times(1)).findByEmail(email);
        verifyNoInteractions(deleteUserOutputGateway);
    }
}