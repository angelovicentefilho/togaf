package br.com.jtech.services.togaf.core.application.domains;

import br.com.jtech.services.togaf.core.application.domains.Role;
import br.com.jtech.services.togaf.core.application.domains.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UserTest {

    @Test
    void isValid_ValidUser_ReturnsTrue() {
        // Arrange
        User user = new User();
        user.setEmail("test@example.com");
        user.setPassword("password");
        user.setUsername("username");

        // Act
        boolean isValid = user.isValid();

        // Assert
        assertTrue(isValid);
    }

    @Test
    void isValid_MissingEmail_ReturnsFalse() {
        // Arrange
        User user = new User();
        user.setPassword("password");
        user.setUsername("username");

        // Act
        boolean isValid = user.isValid();

        // Assert
        assertFalse(isValid);
    }

    @Test
    void isValid_InvalidPassword_ReturnsFalse() {
        // Arrange
        User user = new User();
        user.setEmail("test@example.com");
        user.setPassword("pass");
        user.setUsername("username");

        // Act
        boolean isValid = user.isValid();

        // Assert
        assertFalse(isValid);
    }

    @Test
    void isValid_MissingUsername_ReturnsFalse() {
        // Arrange
        User user = new User();
        user.setEmail("test@example.com");
        user.setPassword("password");

        // Act
        boolean isValid = user.isValid();

        // Assert
        assertFalse(isValid);
    }

    @Test
    void isAdmin_AdminRole_ReturnsTrue() {
        // Arrange
        User user = new User();
        user.setRole(Role.ADMIN);

        // Act
        boolean isAdmin = user.isAdmin();

        // Assert
        assertTrue(isAdmin);
    }

    @Test
    void isAdmin_NonAdminRole_ReturnsFalse() {
        // Arrange
        User user = new User();
        user.setRole(Role.ANALIST);

        // Act
        boolean isAdmin = user.isAdmin();

        // Assert
        assertFalse(isAdmin);
    }
}