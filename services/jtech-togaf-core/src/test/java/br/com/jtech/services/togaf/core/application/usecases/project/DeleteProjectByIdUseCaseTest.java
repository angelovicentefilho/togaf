package br.com.jtech.services.togaf.core.application.usecases.project;

import br.com.jtech.services.togaf.core.application.domains.Project;
import br.com.jtech.services.togaf.core.application.exceptions.ProjectNotFoundException;
import br.com.jtech.services.togaf.core.application.usecases.project.ports.input.DeleteProjectByIdInputGateway;
import br.com.jtech.services.togaf.core.application.usecases.project.ports.output.DeleteProjectOuputGateway;
import br.com.jtech.services.togaf.core.application.usecases.project.ports.output.FindProjectByIdOutputGateway;
import br.com.jtech.services.togaf.core.application.usecases.project.DeleteProjectByIdUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class DeleteProjectByIdUseCaseTest {

    @Mock
    private FindProjectByIdOutputGateway findProjectByIdOutputGateway;
    @Mock
    private DeleteProjectOuputGateway deleteProjectOuputGateway;

    private DeleteProjectByIdInputGateway deleteProjectByIdUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        deleteProjectByIdUseCase = new DeleteProjectByIdUseCase(findProjectByIdOutputGateway, deleteProjectOuputGateway);
    }

    @Test
    void delete_ExistingProject_ProjectDeleted() {
        // Arrange
        Long projectId = 1L;
        Project project = new Project();
        project.setId(projectId);

        when(findProjectByIdOutputGateway.findById(projectId)).thenReturn(Optional.of(project));

        // Act
        deleteProjectByIdUseCase.delete(projectId);

        // Assert
        verify(deleteProjectOuputGateway, times(1)).delete(project);
    }

    @Test
    void delete_NonExistingProject_ThrowsProjectNotFoundException() {
        // Arrange
        Long projectId = 1L;

        when(findProjectByIdOutputGateway.findById(projectId)).thenReturn(Optional.empty());

        // Act & Assert
        ProjectNotFoundException exception = assertThrows(ProjectNotFoundException.class, () -> deleteProjectByIdUseCase.delete(projectId));
        assertEquals("Project '1' not found!", exception.getMessage());

        verifyNoInteractions(deleteProjectOuputGateway);
    }

    @Test
    void delete_NullProject_NoActionTaken() {
        // Arrange
        Long projectId = null;

        // Act
        ProjectNotFoundException exception = assertThrows(ProjectNotFoundException.class, () -> deleteProjectByIdUseCase.delete(projectId));
        assertEquals("Project 'null' not found!", exception.getMessage());

        verifyNoInteractions(deleteProjectOuputGateway);
    }
}