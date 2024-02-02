package br.com.jtech.services.togaf.adapters.adapters.output.comment.repository.entity;

import br.com.jtech.services.togaf.adapters.adapters.output.phase.repository.entity.PhaseEntity;
import br.com.jtech.services.togaf.adapters.adapters.output.project.repository.entity.ProjectEntity;
import br.com.jtech.services.togaf.adapters.adapters.output.user.repository.entity.UserEntity;
import br.com.jtech.services.togaf.core.application.domains.Comment;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Builder
@Entity
@Getter
@Setter
@Table(name = "comments")
@NoArgsConstructor
@AllArgsConstructor
public class CommentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String comment;

    private LocalDate createdAt;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private ProjectEntity project;

    @ManyToOne
    @JoinColumn(name = "phase_id")
    private PhaseEntity phase;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    public static CommentEntity fromDomain(Comment comment) {
        return CommentEntity.builder()
                .id(comment.getId())
                .comment(comment.getComment())
                .createdAt(comment.getCreatedAt())
                .project(ProjectEntity.fromDomain(comment.getProject()))
                .phase(PhaseEntity.fromDomain(comment.getPhase()))
                .user(UserEntity.fromDomain(comment.getUser()))
                .build();
    }

    public static List<CommentEntity> fromDomains(Set<Comment> comments) {
        return comments.stream().map(CommentEntity::fromDomain).toList();
    }

    public static Set<Comment> toDomains(List<CommentEntity> comments) {
        return comments.stream().map(CommentEntity::toDomain).collect(Collectors.toSet());
    }

    public Comment toDomain() {
        return Comment.builder()
                .id(id)
                .comment(comment)
                .createdAt(createdAt)
                .phase(phase.toDomain())
                .project(project.toDomain())
                .user(user.toDomain())
                .build();
    }
}
