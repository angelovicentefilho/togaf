package br.com.jtech.services.togaf.core.application.core.usecases.project;

import br.com.jtech.services.togaf.core.application.core.domains.Project;
import br.com.jtech.services.togaf.core.application.ports.input.CreateProjectInputGateway;
import br.com.jtech.services.togaf.core.application.ports.output.CreateProjectOutputGateway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CreateProjectUseCaseTest {

    @Mock
    private CreateProjectOutputGateway createProjectOutputGateway;

    private CreateProjectInputGateway createProjectUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        createProjectUseCase = new CreateProjectUseCase(createProjectOutputGateway);
    }

    @Test
    void create_ValidProject_ProjectCreated() {
        // Arrange
        Project project = new Project();
        project.setId(1L);
        project.setName("Project Name");

        when(createProjectOutputGateway.create(project)).thenReturn(Optional.of(project));

        // Act
        Optional<Project> createdProject = createProjectUseCase.create(project);

        // Assert
        assertTrue(createdProject.isPresent());
        assertEquals(project, createdProject.get());
        verify(createProjectOutputGateway, times(1)).create(project);
    }

    @Test
    void create_NullProject_ProjectNotCreated() {
        // Arrange
        Project project = null;

        // Act
        Optional<Project> createdProject = createProjectUseCase.create(null);

        // Assert
        assertFalse(createdProject.isPresent());
        verify(createProjectOutputGateway, never()).create(any(Project.class));}
}