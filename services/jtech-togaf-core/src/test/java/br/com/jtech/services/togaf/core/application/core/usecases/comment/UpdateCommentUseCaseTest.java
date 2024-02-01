package br.com.jtech.services.togaf.core.application.core.usecases.comment;

import br.com.jtech.services.togaf.core.application.core.domains.Comment;
import br.com.jtech.services.togaf.core.application.core.domains.Phase;
import br.com.jtech.services.togaf.core.application.core.domains.Project;
import br.com.jtech.services.togaf.core.application.core.domains.User;
import br.com.jtech.services.togaf.core.application.core.exceptions.CommentNotFoundException;
import br.com.jtech.services.togaf.core.application.core.exceptions.CommentNotValidException;
import br.com.jtech.services.togaf.core.application.ports.output.FindCommentByIdOutputGateway;
import br.com.jtech.services.togaf.core.application.ports.output.UpdateCommentOutputGateway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UpdateCommentUseCaseTest {

    @Mock
    private UpdateCommentOutputGateway updateCommentOutputGateway;
    @Mock
    private FindCommentByIdOutputGateway findCommentByIdOutputGateway;

    private UpdateCommentUseCase updateCommentUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        updateCommentUseCase = new UpdateCommentUseCase(updateCommentOutputGateway, findCommentByIdOutputGateway);
    }

    @Test
    void update_ValidComment_CommentUpdated() {
        // Arrange
        Comment comment = new Comment();
        Project project = new Project();
        project.setId(1L);
        Phase phase = new Phase();
        phase.setId(1L);
        User user = new User();
        user.setId(1L);

        comment.setProject(project);
        comment.setId(1L);
        comment.setPhase(phase);
        comment.setComment("Comment");
        user.setEmail("test@example.com");
        comment.setUser(user);
        comment.setPhase(phase);
        comment.setCreatedAt(LocalDate.now());

        when(findCommentByIdOutputGateway.findById(1L)).thenReturn(Optional.of(comment));

        // Act
        Optional<Comment> updatedComment = updateCommentUseCase.update(comment);

        // Assert
        assertTrue(updatedComment.isPresent());
        verify(updateCommentOutputGateway, times(1)).update(comment);
    }

    @Test
    void update_InvalidComment_ThrowsCommentNotValidException() {
        // Arrange
        Comment comment = new Comment();
        Project project = new Project();
        project.setId(1L);
        Phase phase = new Phase();
        phase.setId(1L);
        User user = new User();
        user.setId(1L);

        comment.setPhase(phase);
        comment.setComment("Comment");
        user.setEmail("test@example.com");
        comment.setUser(user);
        comment.setPhase(phase);
        comment.setCreatedAt(LocalDate.now());

        // Act & Assert
        assertThrows(CommentNotValidException.class, () -> updateCommentUseCase.update(comment));
        verifyNoInteractions(findCommentByIdOutputGateway, updateCommentOutputGateway);
    }

    @Test
    void update_CommentNotFound_ThrowsCommentNotFoundException() {
        // Arrange
        Comment comment = new Comment();
        Project project = new Project();
        project.setId(1L);
        Phase phase = new Phase();
        phase.setId(1L);
        User user = new User();
        user.setId(1L);

        comment.setProject(project);
        comment.setId(1L);
        comment.setPhase(phase);
        comment.setComment("Comment");
        user.setEmail("test@example.com");
        comment.setUser(user);
        comment.setPhase(phase);
        comment.setCreatedAt(LocalDate.now());

        when(findCommentByIdOutputGateway.findById(1L)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(CommentNotFoundException.class, () -> updateCommentUseCase.update(comment));
        verify(findCommentByIdOutputGateway, times(1)).findById(1L);
        verifyNoInteractions(updateCommentOutputGateway);
    }
}