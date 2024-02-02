package br.com.jtech.services.togaf.core.application.core.domains;

import br.com.jtech.services.togaf.core.application.core.domains.Comment;
import br.com.jtech.services.togaf.core.application.core.domains.Model;
import br.com.jtech.services.togaf.core.application.core.domains.Phase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ProjectTest {

    private Project project;

    @BeforeEach
    void setUp() {
        project = new Project();
    }

    @Test
    void isValid_ValidProject_ReturnsTrue() {
        // Arrange
        project.setId(1L);
        project.setName("Test Project");
        project.setModel(new Model());

        // Act
        boolean isValid = project.isValid();

        // Assert
        assertTrue(isValid);
    }

    @Test
    void isValid_NullId_ReturnsFalse() {
        // Arrange
        project.setName("Test Project");
        project.setModel(new Model());

        // Act
        boolean isValid = project.isValid();

        // Assert
        assertFalse(isValid);
    }

    @Test
    void isValid_NullName_ReturnsFalse() {
        // Arrange
        project.setId(1L);
        project.setModel(new Model());

        // Act
        boolean isValid = project.isValid();

        // Assert
        assertFalse(isValid);
    }

    @Test
    void isValid_NullModel_ReturnsFalse() {
        // Arrange
        project.setId(1L);
        project.setName("Test Project");

        // Act
        boolean isValid = project.isValid();

        // Assert
        assertFalse(isValid);
    }

    @Test
    void isValid_NullIdNameModel_ReturnsFalse() {
        // Arrange
        project.setPhase(new Phase());
        project.setComments(new HashSet<>());

        // Act
        boolean isValid = project.isValid();

        // Assert
        assertFalse(isValid);
    }
}