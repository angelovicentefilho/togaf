package br.com.jtech.services.togaf.core.application.usecases.phase;

import br.com.jtech.services.togaf.core.application.domains.Phase;
import br.com.jtech.services.togaf.core.application.usecases.phase.ports.input.CreatePhaseInputGateway;
import br.com.jtech.services.togaf.core.application.usecases.phase.ports.output.CreatePhaseOutputGateway;
import br.com.jtech.services.togaf.core.application.usecases.phase.CreatePhaseUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CreatePhaseUseCaseTest {

    @Mock
    private CreatePhaseOutputGateway createPhaseOutputGateway;

    private CreatePhaseInputGateway createPhaseUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        createPhaseUseCase = new CreatePhaseUseCase(createPhaseOutputGateway);
    }

    @Test
    void create_ValidPhase_PhaseCreated() {
        // Arrange
        Phase phase = new Phase();
        phase.setName("TestPhase");

        when(createPhaseOutputGateway.create(phase)).thenReturn(Optional.of(phase));

        // Act
        Optional<Phase> createdPhase = createPhaseUseCase.create(phase);

        // Assert
        assertTrue(createdPhase.isPresent());
        assertEquals(phase, createdPhase.get());
        verify(createPhaseOutputGateway, times(1)).create(phase);
    }

    @Test
    void create_NullPhase_PhaseNotCreated() {
        // Arrange
        Phase phase = null;

        // Act
        Optional<Phase> createdPhase = createPhaseUseCase.create(phase);

        // Assert
        assertFalse(createdPhase.isPresent());
    }
}