package br.com.jtech.services.togaf.core.application.core.usecases.comment;

import br.com.jtech.services.togaf.core.application.core.domains.Comment;
import br.com.jtech.services.togaf.core.application.core.domains.Phase;
import br.com.jtech.services.togaf.core.application.core.domains.Project;
import br.com.jtech.services.togaf.core.application.core.domains.User;
import br.com.jtech.services.togaf.core.application.core.exceptions.CommentNotValidException;
import br.com.jtech.services.togaf.core.application.core.exceptions.PhaseNotFoundException;
import br.com.jtech.services.togaf.core.application.core.exceptions.UserNotFoundException;
import br.com.jtech.services.togaf.core.application.ports.output.DeleteCommentOutputGateway;
import br.com.jtech.services.togaf.core.application.ports.output.FindCommentByUserAndPhaseAndCreatedAtOutputGateway;
import br.com.jtech.services.togaf.core.application.ports.output.FindPhaseByIdOutputGateway;
import br.com.jtech.services.togaf.core.application.ports.output.FindUserByEmailOutputGateway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class DeleteCommentByPhaseUseCaseTest {

    @Mock
    private FindCommentByUserAndPhaseAndCreatedAtOutputGateway findCommentByUserAndPhaseAndCreatedAtOutputGateway;
    @Mock
    private FindUserByEmailOutputGateway findUserByEmailOutputGateway;
    @Mock
    private DeleteCommentOutputGateway deleteCommentOutputGateway;
    @Mock
    private FindPhaseByIdOutputGateway findPhaseByIdOutputGateway;

    private DeleteCommentByPhaseUseCase deleteCommentByPhaseUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        deleteCommentByPhaseUseCase = new DeleteCommentByPhaseUseCase(
                findCommentByUserAndPhaseAndCreatedAtOutputGateway,
                findUserByEmailOutputGateway,
                deleteCommentOutputGateway,
                findPhaseByIdOutputGateway
        );
    }

    @Test
    void delete_ValidComment_DeletesComment() {
        // Arrange
        Comment comment = new Comment();
        Project project = new Project();
        project.setId(1L);
        Phase phase = new Phase();
        phase.setId(1L);
        User user = new User();
        user.setId(1L);

        comment.setProject(project);
        comment.setPhase(phase);
        comment.setComment("Comment");
        user.setEmail("test@example.com");
        comment.setUser(user);
        comment.setPhase(phase);
        comment.setCreatedAt(LocalDate.now());

        when(findUserByEmailOutputGateway.findByEmail("test@example.com")).thenReturn(Optional.of(user));
        when(findPhaseByIdOutputGateway.findById(1L)).thenReturn(Optional.of(phase));
        when(findCommentByUserAndPhaseAndCreatedAtOutputGateway.findByUserAndPhaseAndCreateAt(user, phase, LocalDate.now())).thenReturn(Optional.of(comment));

        // Act
        deleteCommentByPhaseUseCase.delete(comment);

        // Assert
        verify(deleteCommentOutputGateway, times(1)).delete(comment);
    }

    @Test
    void delete_InvalidComment_ThrowsCommentNotValidException() {
        // Arrange
        Comment comment = new Comment();

        // Act & Assert
        assertThrows(CommentNotValidException.class, () -> deleteCommentByPhaseUseCase.delete(comment));
        verifyNoInteractions(findUserByEmailOutputGateway, findPhaseByIdOutputGateway, findCommentByUserAndPhaseAndCreatedAtOutputGateway, deleteCommentOutputGateway);
    }

    @Test
    void delete_UserNotFound_ThrowsUserNotFoundException() {
        // Arrange
        Comment comment = new Comment();
        Project project = new Project();
        project.setId(1L);
        Phase phase = new Phase();
        phase.setId(1L);
        User user = new User();
        user.setId(1L);

        comment.setProject(project);
        comment.setPhase(phase);
        comment.setComment("Comment");
        user.setEmail("test@example.com");
        comment.setUser(user);
        comment.setPhase(phase);
        comment.setCreatedAt(LocalDate.now());

        when(findUserByEmailOutputGateway.findByEmail("test@example.com")).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(UserNotFoundException.class, () -> deleteCommentByPhaseUseCase.delete(comment));
        verify(findUserByEmailOutputGateway, times(1)).findByEmail("test@example.com");
        verifyNoInteractions(findPhaseByIdOutputGateway, findCommentByUserAndPhaseAndCreatedAtOutputGateway, deleteCommentOutputGateway);
    }

    @Test
    void delete_PhaseNotFound_ThrowsPhaseNotFoundException() {
        // Arrange
        Comment comment = new Comment();
        Project project = new Project();
        project.setId(1L);
        Phase phase = new Phase();
        phase.setId(1L);
        User user = new User();
        user.setId(1L);

        comment.setProject(project);
        comment.setPhase(phase);
        comment.setComment("Comment");
        user.setEmail("test@example.com");
        comment.setUser(user);
        comment.setPhase(phase);
        comment.setCreatedAt(LocalDate.now());

        when(findUserByEmailOutputGateway.findByEmail("test@example.com")).thenReturn(Optional.of(user));
        when(findPhaseByIdOutputGateway.findById(1L)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(PhaseNotFoundException.class, () -> deleteCommentByPhaseUseCase.delete(comment));
        verify(findUserByEmailOutputGateway, times(1)).findByEmail("test@example.com");
        verify(findPhaseByIdOutputGateway, times(1)).findById(1L);
        verifyNoInteractions(findCommentByUserAndPhaseAndCreatedAtOutputGateway, deleteCommentOutputGateway);
    }

    @Test
    void delete_CommentNotFound_NoActionTaken() {
        // Arrange
        Comment comment = new Comment();
        Project project = new Project();
        project.setId(1L);
        Phase phase = new Phase();
        phase.setId(1L);
        User user = new User();
        user.setId(1L);

        comment.setProject(project);
        comment.setPhase(phase);
        comment.setComment("Comment");
        user.setEmail("test@example.com");
        comment.setUser(user);
        comment.setPhase(phase);
        comment.setCreatedAt(LocalDate.now());

        when(findUserByEmailOutputGateway.findByEmail("test@example.com")).thenReturn(Optional.of(user));
        when(findPhaseByIdOutputGateway.findById(1L)).thenReturn(Optional.of(phase));
        when(findCommentByUserAndPhaseAndCreatedAtOutputGateway.findByUserAndPhaseAndCreateAt(user, phase, LocalDate.now())).thenReturn(Optional.empty());

        // Act
        deleteCommentByPhaseUseCase.delete(comment);

        // Assert
        verifyNoInteractions(deleteCommentOutputGateway);
    }
}