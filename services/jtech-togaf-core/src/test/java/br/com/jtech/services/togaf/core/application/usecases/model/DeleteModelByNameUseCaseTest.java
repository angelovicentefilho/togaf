package br.com.jtech.services.togaf.core.application.usecases.model;

import br.com.jtech.services.togaf.core.application.domains.Model;
import br.com.jtech.services.togaf.core.application.exceptions.ModelNotFoundException;
import br.com.jtech.services.togaf.core.application.usecases.model.ports.input.DeleteModelByNameInputGateway;
import br.com.jtech.services.togaf.core.application.usecases.model.ports.output.DeleteModelOutputGateway;
import br.com.jtech.services.togaf.core.application.usecases.model.ports.output.FindModelByNameOutputGateway;
import br.com.jtech.services.togaf.core.application.usecases.model.DeleteModelByNameUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class DeleteModelByNameUseCaseTest {

    @Mock
    private DeleteModelOutputGateway deleteModelOutputGateway;
    @Mock
    private FindModelByNameOutputGateway findModelByNameOutputGateway;

    private DeleteModelByNameInputGateway deleteModelByNameUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        deleteModelByNameUseCase = new DeleteModelByNameUseCase(deleteModelOutputGateway, findModelByNameOutputGateway);
    }

    @Test
    void delete_ExistingModel_ModelDeleted() {
        // Arrange
        String modelName = "TestModel";
        Model model = new Model();

        when(findModelByNameOutputGateway.findByName(modelName)).thenReturn(Optional.of(model));

        // Act
        assertDoesNotThrow(() -> deleteModelByNameUseCase.delete(modelName));

        // Assert
        verify(findModelByNameOutputGateway, times(1)).findByName(modelName);
        verify(deleteModelOutputGateway, times(1)).delete(model);
    }

    @Test
    void delete_NonExistingModel_ThrowsModelNotFoundException() {
        // Arrange
        String modelName = "NonExistingModel";

        when(findModelByNameOutputGateway.findByName(modelName)).thenReturn(Optional.empty());

        // Act & Assert
        ModelNotFoundException exception = assertThrows(ModelNotFoundException.class, () -> deleteModelByNameUseCase.delete(modelName));
        assertEquals("Model 'NonExistingModel' not found!", exception.getMessage());

        verify(findModelByNameOutputGateway, times(1)).findByName(modelName);
        verifyNoInteractions(deleteModelOutputGateway);
    }

    @Test
    void delete_EmptyName_ThrowsModelNotFoundException() {
        // Arrange
        String modelName = "";

        // Act & Assert
        ModelNotFoundException exception = assertThrows(ModelNotFoundException.class, () -> deleteModelByNameUseCase.delete(modelName));
        assertEquals("Model '' not found!", exception.getMessage());
    }
}