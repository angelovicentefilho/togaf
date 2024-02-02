package br.com.jtech.services.togaf.core.application.usecases.model;

import br.com.jtech.services.togaf.core.application.domains.Model;
import br.com.jtech.services.togaf.core.application.usecases.model.ports.output.CreateModelOutputGateway;
import br.com.jtech.services.togaf.core.application.usecases.model.CreateModelUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CreateModelUseCaseTest {

    @Mock
    private CreateModelOutputGateway createModelOutputGateway;

    private CreateModelUseCase createModelUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        createModelUseCase = new CreateModelUseCase(createModelOutputGateway);
    }

    @Test
    void create_ValidModel_ModelCreated() {
        // Arrange
        Model model = new Model();

        when(createModelOutputGateway.create(model)).thenReturn(Optional.of(model));

        // Act
        Optional<Model> createdModel = createModelUseCase.create(model);

        // Assert
        assertTrue(createdModel.isPresent());
        assertEquals(model, createdModel.get());
        verify(createModelOutputGateway, times(1)).create(model);
    }

    @Test
    void create_InvalidModel_ModelNotCreated() {
        // Arrange
        Model model = new Model();

        when(createModelOutputGateway.create(model)).thenReturn(Optional.empty());

        // Act
        Optional<Model> createdModel = createModelUseCase.create(model);

        // Assert
        assertFalse(createdModel.isPresent());
        verify(createModelOutputGateway, times(1)).create(model);
    }
}