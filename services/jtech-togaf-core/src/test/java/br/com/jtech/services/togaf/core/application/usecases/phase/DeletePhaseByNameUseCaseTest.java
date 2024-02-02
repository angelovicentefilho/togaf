package br.com.jtech.services.togaf.core.application.usecases.phase;

import br.com.jtech.services.togaf.core.application.domains.Phase;
import br.com.jtech.services.togaf.core.application.exceptions.PhaseNotFoundException;
import br.com.jtech.services.togaf.core.application.usecases.phase.ports.input.DeletePhaseByNameInputGateway;
import br.com.jtech.services.togaf.core.application.usecases.phase.ports.output.DeletePhaseOutputGateway;
import br.com.jtech.services.togaf.core.application.usecases.phase.ports.output.FindPhaseByNameOutputGateway;
import br.com.jtech.services.togaf.core.application.usecases.phase.DeletePhaseByNameUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class DeletePhaseByNameUseCaseTest {

    @Mock
    private FindPhaseByNameOutputGateway findPhaseByNameOutputGateway;
    @Mock
    private DeletePhaseOutputGateway deletePhaseOutputGateway;

    private DeletePhaseByNameInputGateway deletePhaseByNameUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        deletePhaseByNameUseCase = new DeletePhaseByNameUseCase(findPhaseByNameOutputGateway, deletePhaseOutputGateway);
    }

    @Test
    void delete_ExistingPhase_PhaseDeleted() {
        // Arrange
        String phaseName = "TestPhase";
        Phase phase = new Phase();
        phase.setName(phaseName);

        when(findPhaseByNameOutputGateway.findByName(phaseName)).thenReturn(Optional.of(phase));

        // Act
        deletePhaseByNameUseCase.delete(phaseName);

        // Assert
        verify(deletePhaseOutputGateway, times(1)).delete(phase);
    }

    @Test
    void delete_NonExistingPhase_ThrowsPhaseNotFoundException() {
        // Arrange
        String phaseName = "NonExistingPhase";

        when(findPhaseByNameOutputGateway.findByName(phaseName)).thenReturn(Optional.empty());

        // Act & Assert
        PhaseNotFoundException exception = assertThrows(PhaseNotFoundException.class, () -> deletePhaseByNameUseCase.delete(phaseName));
        assertEquals("Phase 'NonExistingPhase' not found!", exception.getMessage());

        verifyNoInteractions(deletePhaseOutputGateway);
    }

    @Test
    void delete_NullPhaseName_NoActionTaken() {
        // Arrange
        String phaseName = null;

        // Act
        PhaseNotFoundException exception = assertThrows(PhaseNotFoundException.class, () -> deletePhaseByNameUseCase.delete(null));

        // Assert
        assertEquals("Phase 'null' not found!", exception.getMessage());
        verifyNoInteractions(findPhaseByNameOutputGateway, deletePhaseOutputGateway);
    }
}