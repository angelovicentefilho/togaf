package br.com.jtech.services.togaf.core.application.domains;

import br.com.jtech.services.togaf.core.application.domains.Model;
import br.com.jtech.services.togaf.core.application.domains.Phase;
import br.com.jtech.services.togaf.core.application.domains.Project;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ModelTest {

    private Model model;

    @BeforeEach
    void setUp() {
        model = new Model();
    }

    @Test
    void hasPhases_WithPhases_ReturnsTrue() {
        // Arrange
        Set<Phase> phases = new HashSet<>();
        phases.add(new Phase());
        model.setPhases(phases);

        // Act
        boolean hasPhases = model.hasPhases();

        // Assert
        assertTrue(hasPhases);
    }

    @Test
    void hasPhases_NullPhases_ReturnsFalse() {
        // Arrange
        model.setPhases(null);

        // Act
        boolean hasPhases = model.hasPhases();

        // Assert
        assertFalse(hasPhases);
    }

    @Test
    void hasPhases_EmptyPhases_ReturnsFalse() {
        // Arrange
        model.setPhases(new HashSet<>());

        // Act
        boolean hasPhases = model.hasPhases();

        // Assert
        assertFalse(hasPhases);
    }

    @Test
    void hasPhases_WithProjects_ReturnsFalse() {
        // Arrange
        Set<Project> projects = new HashSet<>();
        projects.add(new Project());
        model.setProjects(projects);

        // Act
        boolean hasPhases = model.hasPhases();

        // Assert
        assertFalse(hasPhases);
    }
}