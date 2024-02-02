package br.com.jtech.services.togaf.core.application.usecases.model;

import br.com.jtech.services.togaf.core.application.domains.Model;
import br.com.jtech.services.togaf.core.application.domains.Phase;
import br.com.jtech.services.togaf.core.application.exceptions.ModelNotFoundException;
import br.com.jtech.services.togaf.core.application.usecases.model.ports.input.AddPhasesToModelInputGateway;
import br.com.jtech.services.togaf.core.application.usecases.model.ports.output.FindModelByNameOutputGateway;
import br.com.jtech.services.togaf.core.application.usecases.model.ports.output.UpdateModelOutputGateway;
import br.com.jtech.services.togaf.core.application.usecases.model.AddPhasesToModelUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AddPhasesToModelUseCaseTest {

    @Mock
    private FindModelByNameOutputGateway findModelByNameOutputGateway;
    @Mock
    private UpdateModelOutputGateway updateModelOutputGateway;

    private AddPhasesToModelInputGateway addPhasesToModelUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        addPhasesToModelUseCase = new AddPhasesToModelUseCase(findModelByNameOutputGateway, updateModelOutputGateway);
    }

    @Test
    void addOrUpdateModelWithPhases_ModelWithPhases_ModelUpdated() {
        // Arrange
        String modelName = "TestModel";
        Set<Phase> phases = new HashSet<>();
        var phase1 = new Phase();
        var phase2 = new Phase();
        phase1.setName("Phase 1");
        phase2.setName("Phase 2");
        phases.add(phase1);
        phases.add(phase2);
        Model model = new Model();
        model.setName(modelName);
        model.setPhases(phases);

        when(findModelByNameOutputGateway.findByName(modelName)).thenReturn(Optional.of(model));
        when(updateModelOutputGateway.update(model)).thenReturn(Optional.of(model));

        // Act
        Optional<Model> updatedModel = addPhasesToModelUseCase.addOrUpdateModelWithPhases(model);

        // Assert
        assertTrue(updatedModel.isPresent());
        assertEquals(model, updatedModel.get());
        verify(findModelByNameOutputGateway, times(1)).findByName(modelName);
        verify(updateModelOutputGateway, times(1)).update(model);
    }

    @Test
    void addOrUpdateModelWithPhases_ModelWithoutPhases_ModelNotUpdated() {
        // Arrange
        Model model = new Model();
        model.setName("TestModel");

        ModelNotFoundException exception = assertThrows(ModelNotFoundException.class, () -> addPhasesToModelUseCase.addOrUpdateModelWithPhases(model));
        assertEquals("Model 'TestModel' not found.", exception.getMessage());
    }

    @Test
    void addOrUpdateModelWithPhases_NonExistingModel_ThrowsModelNotFoundException() {
        // Arrange
        String modelName = "NonExistingModel";
        Model model = new Model();
        model.setName("NonExistingModel");

        when(findModelByNameOutputGateway.findByName(modelName)).thenReturn(Optional.empty());

        // Act & Assert
        ModelNotFoundException exception = assertThrows(ModelNotFoundException.class, () -> addPhasesToModelUseCase.addOrUpdateModelWithPhases(model));
        assertEquals("Model 'NonExistingModel' not found.", exception.getMessage());
    }
}