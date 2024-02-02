package br.com.jtech.services.togaf.core.application.usecases.comment;

import br.com.jtech.services.togaf.core.application.domains.Comment;
import br.com.jtech.services.togaf.core.application.domains.Phase;
import br.com.jtech.services.togaf.core.application.domains.Project;
import br.com.jtech.services.togaf.core.application.domains.User;
import br.com.jtech.services.togaf.core.application.exceptions.CommentNotValidException;
import br.com.jtech.services.togaf.core.application.exceptions.CommentProjectOrPhaseException;
import br.com.jtech.services.togaf.core.application.usecases.comment.ports.output.CreateCommentOutputGateway;
import br.com.jtech.services.togaf.core.application.usecases.phase.ports.output.FindPhaseByIdOutputGateway;
import br.com.jtech.services.togaf.core.application.usecases.project.ports.output.FindProjectByIdOutputGateway;
import br.com.jtech.services.togaf.core.application.usecases.comment.CreateCommentUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CreateCommentUseCaseTest {

    @Mock
    private CreateCommentOutputGateway createCommentOutputGateway;
    @Mock
    private FindProjectByIdOutputGateway findProjectByIdOutputGateway;
    @Mock
    private FindPhaseByIdOutputGateway findPhaseByIdOutputGateway;

    private CreateCommentUseCase createCommentUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        createCommentUseCase = new CreateCommentUseCase(
                createCommentOutputGateway,
                findProjectByIdOutputGateway,
                findPhaseByIdOutputGateway
        );
    }

    @Test
    void create_ValidComment_ReturnsOptionalComment() {
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
        comment.setUser(user);
        comment.setComment("Comment");

        when(findProjectByIdOutputGateway.findById(1L)).thenReturn(Optional.of(project));
        when(findPhaseByIdOutputGateway.findById(1L)).thenReturn(Optional.of(phase));
        when(createCommentOutputGateway.create(comment)).thenReturn(Optional.of(comment));

        // Act
        Optional<Comment> result = createCommentUseCase.create(comment);

        // Assert
        assertTrue(result.isPresent());
        assertEquals(comment, result.get());
        verify(createCommentOutputGateway, times(1)).create(comment);
    }

    @Test
    void create_InvalidComment_ThrowsCommentNotValidException() {
        // Arrange
        Comment comment = new Comment();

        // Act & Assert
        assertThrows(CommentNotValidException.class, () -> createCommentUseCase.create(comment));
        verifyNoInteractions(findProjectByIdOutputGateway, findPhaseByIdOutputGateway, createCommentOutputGateway);
    }
    @Test
    void create_ProjectNotFound_ThrowsCommentProjectOrPhaseException() {
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
        comment.setUser(user);
        comment.setComment("Comment");

        when(findProjectByIdOutputGateway.findById(1L)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(CommentProjectOrPhaseException.class, () -> createCommentUseCase.create(comment),
                "Expected CommentProjectOrPhaseException to be thrown");
        verify(findProjectByIdOutputGateway, times(1)).findById(1L);
    }

    @Test
    void create_PhaseNotFound_ThrowsCommentProjectOrPhaseException() {
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
        comment.setUser(user);
        comment.setComment("Comment");

        when(findProjectByIdOutputGateway.findById(1L)).thenReturn(Optional.of(project));
        when(findPhaseByIdOutputGateway.findById(1L)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(CommentProjectOrPhaseException.class, () -> createCommentUseCase.create(comment),
                "Expected CommentProjectOrPhaseException to be thrown");
        verify(findProjectByIdOutputGateway, times(1)).findById(1L);
        verify(findPhaseByIdOutputGateway, times(1)).findById(1L);
        verifyNoInteractions(createCommentOutputGateway);
    }

}