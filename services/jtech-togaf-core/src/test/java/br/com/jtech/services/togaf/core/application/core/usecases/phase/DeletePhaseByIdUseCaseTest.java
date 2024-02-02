package br.com.jtech.services.togaf.core.application.core.usecases.phase;

import br.com.jtech.services.togaf.core.application.core.domains.Phase;
import br.com.jtech.services.togaf.core.application.core.exceptions.PhaseNotFoundException;
import br.com.jtech.services.togaf.core.application.ports.input.DeletePhaseByIdInputGateway;
import br.com.jtech.services.togaf.core.application.ports.output.DeletePhaseOutputGateway;
import br.com.jtech.services.togaf.core.application.ports.output.FindPhaseByIdOutputGateway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class DeletePhaseByIdUseCaseTest {

    @Mock
    private FindPhaseByIdOutputGateway findPhaseByIdOutputGateway;
    @Mock
    private DeletePhaseOutputGateway deletePhaseOutputGateway;

    private DeletePhaseByIdInputGateway deletePhaseByIdUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        deletePhaseByIdUseCase = new DeletePhaseByIdUseCase(findPhaseByIdOutputGateway, deletePhaseOutputGateway);
    }

    @Test
    void delete_ExistingPhase_PhaseDeleted() {
        // Arrange
        Long phaseId = 1L;
        Phase phase = new Phase();
        phase.setName("TestPhase");
        phase.setId(phaseId);

        when(findPhaseByIdOutputGateway.findById(phaseId))
                .thenReturn(Optional.of(phase));

        // Act
        deletePhaseByIdUseCase.delete(phaseId);

        // Assert
        verify(deletePhaseOutputGateway, times(1)).delete(phase);
    }

    @Test
    void delete_NonExistingPhase_ThrowsPhaseNotFoundException() {
        // Arrange
        Long phaseId = 1L;

        when(findPhaseByIdOutputGateway.findById(phaseId)).thenReturn(Optional.empty());

        // Act & Assert
        PhaseNotFoundException exception = assertThrows(PhaseNotFoundException.class, () -> deletePhaseByIdUseCase.delete(phaseId));
        assertEquals("Phase '1' not found!", exception.getMessage());
        verify(findPhaseByIdOutputGateway, times(1)).findById(phaseId);
    }

    @Test
    void delete_NullPhaseId_NoActionTaken() {
        // Arrange
        Long phaseId = null;

        // Act
        PhaseNotFoundException exception = assertThrows(PhaseNotFoundException.class, () -> deletePhaseByIdUseCase.delete(phaseId));

        // Assert
        assertEquals("Phase 'null' not found!", exception.getMessage());
    }
}