package br.com.jtech.services.togaf.core.application.domains;

import br.com.jtech.services.togaf.core.application.domains.Comment;
import br.com.jtech.services.togaf.core.application.domains.Phase;
import br.com.jtech.services.togaf.core.application.domains.Project;
import br.com.jtech.services.togaf.core.application.domains.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CommentTest {

    private Comment comment;

    @BeforeEach
    void setUp() {
        comment = new Comment();
    }

    @Test
    void isComment_WithComment_ReturnsTrue() {
        // Arrange
        comment.setComment("This is a comment");

        // Act
        boolean isComment = comment.isComment();

        // Assert
        assertTrue(isComment);
    }

    @Test
    void isComment_NullComment_ReturnsFalse() {
        // Arrange
        comment.setComment(null);

        // Act
        boolean isComment = comment.isComment();

        // Assert
        assertFalse(isComment);
    }

    @Test
    void isValid_ValidComment_ReturnsTrue() {
        // Arrange
        comment.setComment("This is a comment");
        var project = new Project();
        project.setId(1L);
        comment.setProject(project);
        var phase = new Phase();
        phase.setId(1L);
        comment.setPhase(phase);
        var user = new User();
        user.setId(1L);
        comment.setUser(user);
        comment.setCreatedAt(LocalDate.now());

        // Act
        boolean isValid = comment.isValid();

        // Assert
        assertTrue(isValid);
    }

    @Test
    void isValid_NullComment_ReturnsFalse() {
        // Arrange
        comment.setComment(null);
        comment.setProject(new Project());
        comment.setPhase(new Phase());
        comment.setUser(new User());
        comment.setCreatedAt(LocalDate.now());

        // Act
        boolean isValid = comment.isValid();

        // Assert
        assertFalse(isValid);
    }

    @Test
    void isValid_NullProject_ReturnsFalse() {
        // Arrange
        comment.setComment("This is a comment");
        comment.setProject(null);
        comment.setPhase(new Phase());
        comment.setUser(new User());
        comment.setCreatedAt(LocalDate.now());

        // Act
        boolean isValid = comment.isValid();

        // Assert
        assertFalse(isValid);
    }

    @Test
    void isValid_NullPhase_ReturnsFalse() {
        // Arrange
        comment.setComment("This is a comment");
        comment.setProject(new Project());
        comment.setPhase(null);
        comment.setUser(new User());
        comment.setCreatedAt(LocalDate.now());

        // Act
        boolean isValid = comment.isValid();

        // Assert
        assertFalse(isValid);
    }

    @Test
    void isValid_NullUser_ReturnsFalse() {
        // Arrange
        comment.setComment("This is a comment");
        comment.setProject(new Project());
        comment.setPhase(new Phase());
        comment.setUser(null);
        comment.setCreatedAt(LocalDate.now());

        // Act
        boolean isValid = comment.isValid();

        // Assert
        assertFalse(isValid);
    }

    @Test
    void isValid_NullCreatedAt_ReturnsFalse() {
        // Arrange
        comment.setComment("This is a comment");
        comment.setProject(new Project());
        comment.setPhase(new Phase());
        comment.setUser(new User());
        comment.setCreatedAt(null);

        // Act
        boolean isValid = comment.isValid();

        // Assert
        assertFalse(isValid);
    }
}