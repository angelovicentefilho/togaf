package br.com.jtech.services.togaf.core.application.usecases.phase;

import br.com.jtech.services.togaf.core.application.domains.Phase;
import br.com.jtech.services.togaf.core.application.usecases.phase.ports.input.UpdatePhaseInputGateway;
import br.com.jtech.services.togaf.core.application.usecases.phase.ports.output.UpdatePhaseOutputGateway;
import br.com.jtech.services.togaf.core.application.usecases.phase.UpdatePhaseUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UpdatePhaseUseCaseTest {

    @Mock
    private UpdatePhaseOutputGateway updatePhaseOutputGateway;

    private UpdatePhaseInputGateway updatePhaseUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        updatePhaseUseCase = new UpdatePhaseUseCase(updatePhaseOutputGateway);
    }

    @Test
    void update_ExistingPhase_PhaseUpdated() {
        // Arrange
        Phase phase = new Phase();
        phase.setName("TestPhase");

        when(updatePhaseOutputGateway.update(phase)).thenReturn(Optional.of(phase));

        // Act
        Optional<Phase> updatedPhase = updatePhaseUseCase.update(phase);

        // Assert
        assertTrue(updatedPhase.isPresent());
        assertEquals(phase, updatedPhase.get());
        verify(updatePhaseOutputGateway, times(1)).update(phase);
    }

    @Test
    void update_NonExistingPhase_PhaseNotUpdated() {
        // Arrange
        Phase phase = new Phase();
        phase.setName("NonExistingPhase");

        when(updatePhaseOutputGateway.update(phase)).thenReturn(Optional.empty());

        // Act
        Optional<Phase> updatedPhase = updatePhaseUseCase.update(phase);

        // Assert
        assertFalse(updatedPhase.isPresent());
        verify(updatePhaseOutputGateway, times(1)).update(phase);
    }

    @Test
    void update_NullPhase_PhaseNotUpdated() {
        // Arrange
        Phase phase = null;

        // Act
        Optional<Phase> updatedPhase = updatePhaseUseCase.update(null);

        // Assert
        assertFalse(updatedPhase.isPresent());
        verify(updatePhaseOutputGateway, never()).update(any(Phase.class));}
}