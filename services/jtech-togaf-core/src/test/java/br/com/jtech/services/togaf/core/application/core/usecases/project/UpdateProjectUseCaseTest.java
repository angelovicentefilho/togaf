package br.com.jtech.services.togaf.core.application.core.usecases.project;

import br.com.jtech.services.togaf.core.application.core.domains.Model;
import br.com.jtech.services.togaf.core.application.core.domains.Project;
import br.com.jtech.services.togaf.core.application.core.exceptions.ProjectNotValidException;
import br.com.jtech.services.togaf.core.application.ports.input.UpdateProjectInputGateway;
import br.com.jtech.services.togaf.core.application.ports.output.UpdateProjectOutputGateway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UpdateProjectUseCaseTest {

    @Mock
    private UpdateProjectOutputGateway updateProjectOutputGateway;

    private UpdateProjectInputGateway updateProjectUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        updateProjectUseCase = new UpdateProjectUseCase(updateProjectOutputGateway);
    }

    @Test
    void update_ExistingProject_ProjectUpdated() {
        // Arrange
        Project project = new Project();
        project.setId(1L);
        project.setName("Project Name");
        project.setModel(new Model());

        when(updateProjectOutputGateway.update(project)).thenReturn(Optional.of(project));

        // Act
        Optional<Project> updatedProject = updateProjectUseCase.update(project);

        // Assert
        assertTrue(updatedProject.isPresent());
        assertEquals(project, updatedProject.get());
        verify(updateProjectOutputGateway, times(1)).update(project);
    }

    @Test
    void update_NonExistingProject_ProjectNotUpdated() {
        // Arrange
        Project project = new Project();
        project.setId(1L);
        project.setName("Project Name");
        project.setModel(new Model());
        when(updateProjectOutputGateway.update(project)).thenReturn(Optional.empty());

        // Act
        Optional<Project> updatedProject = updateProjectUseCase.update(project);

        // Assert
        assertFalse(updatedProject.isPresent());
        verify(updateProjectOutputGateway, times(1)).update(project);
    }

    @Test
    void update_NullProject_ProjectNotUpdated() {
        // Assert
        ProjectNotValidException exception = assertThrows(ProjectNotValidException.class, () -> updateProjectUseCase.update(null));
        assertEquals("Project 'null' not valid!", exception.getMessage());
    }
}