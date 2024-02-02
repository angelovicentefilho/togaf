package br.com.jtech.services.togaf.core.application.core.usecases.user;

import br.com.jtech.services.togaf.core.application.core.domains.User;
import br.com.jtech.services.togaf.core.application.core.exceptions.UserNotValidException;
import br.com.jtech.services.togaf.core.application.ports.input.UpdateUserInputGateway;
import br.com.jtech.services.togaf.core.application.ports.output.UpdateUserOutputGateway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UpdateUserUseCaseTest {

    @Mock
    private UpdateUserOutputGateway updateUserOutputGateway;

    private UpdateUserInputGateway updateUserUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        updateUserUseCase = new UpdateUserUseCase(updateUserOutputGateway);
    }

    @Test
    void update_ValidUser_UserUpdated() {
        // Arrange
        User user = new User();
        user.setEmail("test@example.com");
        user.setPassword("password");
        user.setUsername("username");

        when(updateUserOutputGateway.update(user)).thenReturn(Optional.of(user));

        // Act
        Optional<User> updatedUser = updateUserUseCase.update(user);

        // Assert
        assertTrue(updatedUser.isPresent());
        assertEquals(user, updatedUser.get());
        verify(updateUserOutputGateway, times(1)).update(user);
    }

    @Test
    void update_NullUser_ThrowsUserNotValidException() {
        // Arrange
        User user = null;

        // Act & Assert
        assertThrows(UserNotValidException.class, () -> updateUserUseCase.update(user));
        verifyNoInteractions(updateUserOutputGateway);
    }

    @Test
    void update_InvalidUser_ThrowsUserNotValidException() {
        // Arrange
        User user = new User();

        // Act & Assert
        assertThrows(UserNotValidException.class, () -> updateUserUseCase.update(user));
        verifyNoInteractions(updateUserOutputGateway);
    }
}