package br.com.jtech.services.togaf.core.application.core.usecases.user;

import br.com.jtech.services.togaf.core.application.core.domains.Role;
import br.com.jtech.services.togaf.core.application.core.domains.User;
import br.com.jtech.services.togaf.core.application.core.exceptions.UserAlreadyExistsException;
import br.com.jtech.services.togaf.core.application.core.exceptions.UserDataInvalidException;
import br.com.jtech.services.togaf.core.application.ports.input.CreateUserInputGateway;
import br.com.jtech.services.togaf.core.application.ports.output.CreateUserOutputGateway;
import br.com.jtech.services.togaf.core.application.ports.output.FindUserByEmailOutputGateway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CreateUserUseCaseTest {

    @Mock
    private CreateUserOutputGateway createUserOutputGateway;

    @Mock
    private FindUserByEmailOutputGateway findUserByEmailOutputGateway;

    private CreateUserInputGateway createUserUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        createUserUseCase = new CreateUserUseCase(createUserOutputGateway, findUserByEmailOutputGateway);
    }

    @Test
    void create_ValidUser_UserCreated() {
        // Arrange
        User user = new User();
        user.setEmail("test@example.com");
        user.setUsername("John Doe");
        user.setPassword("password");
        user.setRole(Role.ADMIN);

        when(findUserByEmailOutputGateway.findByEmail(user.getEmail())).thenReturn(Optional.empty());
        when(createUserOutputGateway.create(user)).thenReturn(Optional.of(user));

        // Act
        Optional<User> createdUser = createUserUseCase.create(user);

        // Assert
        assertTrue(createdUser.isPresent());
        assertEquals(user, createdUser.get());
        verify(findUserByEmailOutputGateway, times(1)).findByEmail(user.getEmail());
        verify(createUserOutputGateway, times(1)).create(user);
    }

    @Test
    void create_InvalidUser_ThrowsUserDataInvalidException() {
        // Arrange
        User user = new User();
        user.setEmail("test@example.com");

        // Act & Assert
        assertThrows(UserDataInvalidException.class, () -> createUserUseCase.create(user));
        verifyNoInteractions(findUserByEmailOutputGateway);
        verifyNoInteractions(createUserOutputGateway);
    }

    @Test
    void create_UserAlreadyExists_ThrowsUserAlreadyExistsException() {
        // Arrange
        User user = new User();
        user.setEmail("test@example.com");
        user.setUsername("John Doe");
        user.setPassword("password");
        user.setRole(Role.ADMIN);

        when(findUserByEmailOutputGateway.findByEmail(user.getEmail())).thenReturn(Optional.of(user));

        // Act & Assert
        assertThrows(UserAlreadyExistsException.class, () -> createUserUseCase.create(user));
        verify(findUserByEmailOutputGateway, times(1)).findByEmail(user.getEmail());
        verifyNoInteractions(createUserOutputGateway);
    }
}