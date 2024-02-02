package br.com.jtech.services.togaf.adapters.adapters.output.project.repository.entity;

import br.com.jtech.services.togaf.adapters.adapters.output.comment.repository.entity.CommentEntity;
import br.com.jtech.services.togaf.adapters.adapters.output.model.repository.entity.ModelEntity;
import br.com.jtech.services.togaf.adapters.adapters.output.phase.repository.entity.PhaseEntity;
import br.com.jtech.services.togaf.core.application.domains.Project;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Builder
@Entity
@Getter
@Setter
@Table(name = "projects")
@NoArgsConstructor
@AllArgsConstructor
public class ProjectEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id")
    private Long id;

    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @ManyToOne
    @JoinColumn(name = "model_id")
    private ModelEntity model;

    @ManyToOne
    @JoinColumn(name = "phase_id")
    private PhaseEntity phase;

    @OneToMany(mappedBy = "project")
    private List<CommentEntity> comments;


    public static ProjectEntity fromDomain(Project project) {
        return ProjectEntity.builder()
                .id(project.getId())
                .name(project.getName())
                .description(project.getDescription())
                .model(ModelEntity.fromDomain(project.getModel()))
                .phase(PhaseEntity.fromDomain(project.getPhase()))
                .comments(CommentEntity.fromDomains(project.getComments()))
                .build();
    }

    public static Set<ProjectEntity> fromDomains(Set<Project> projects) {
        return projects.stream().map(ProjectEntity::fromDomain).collect(Collectors.toSet());
    }

    public static Set<Project> toDomains(Set<ProjectEntity> projects) {
        return projects.stream().map(ProjectEntity::toDomain).collect(Collectors.toSet());
    }

    public Project toDomain() {
        return Project.builder()
                .id(id)
                .name(name)
                .description(description)
                .model(model.toDomain())
                .phase(phase.toDomain())
                .comments(CommentEntity.toDomains(comments))
                .build();
    }
}
