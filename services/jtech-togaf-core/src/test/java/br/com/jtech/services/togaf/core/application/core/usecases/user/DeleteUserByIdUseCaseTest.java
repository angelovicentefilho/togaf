package br.com.jtech.services.togaf.core.application.core.usecases.user;

import br.com.jtech.services.togaf.core.application.core.domains.User;
import br.com.jtech.services.togaf.core.application.core.exceptions.UserNotFoundException;
import br.com.jtech.services.togaf.core.application.ports.input.DeleteUserByIdInputGateway;
import br.com.jtech.services.togaf.core.application.ports.output.DeleteUserOutputGateway;
import br.com.jtech.services.togaf.core.application.ports.output.FindUserByIdOutputGateway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class DeleteUserByIdUseCaseTest {

    @Mock
    private FindUserByIdOutputGateway findUserByIdOutputGateway;

    @Mock
    private DeleteUserOutputGateway deleteUserOutputGateway;

    private DeleteUserByIdInputGateway deleteUserByIdUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        deleteUserByIdUseCase = new DeleteUserByIdUseCase(findUserByIdOutputGateway, deleteUserOutputGateway);
    }

    @Test
    void delete_ExistingUser_UserDeleted() {
        // Arrange
        Long id = 1L;
        User user = new User();
        user.setId(id);

        when(findUserByIdOutputGateway.findById(id)).thenReturn(Optional.of(user));

        // Act
        assertDoesNotThrow(() -> deleteUserByIdUseCase.delete(id));

        // Assert
        verify(findUserByIdOutputGateway, times(1)).findById(id);
        verify(deleteUserOutputGateway, times(1)).delete(user);
    }

    @Test
    void delete_NonExistingUser_ThrowsUserNotFoundException() {
        // Arrange
        Long id = 1L;

        when(findUserByIdOutputGateway.findById(id)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(UserNotFoundException.class, () -> deleteUserByIdUseCase.delete(id));
        verify(findUserByIdOutputGateway, times(1)).findById(id);
        verifyNoInteractions(deleteUserOutputGateway);
    }
}