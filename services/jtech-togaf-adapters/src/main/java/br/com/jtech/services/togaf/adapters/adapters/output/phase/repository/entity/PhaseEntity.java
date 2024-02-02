package br.com.jtech.services.togaf.adapters.adapters.output.phase.repository.entity;

import br.com.jtech.services.togaf.adapters.adapters.output.comment.repository.entity.CommentEntity;
import br.com.jtech.services.togaf.adapters.adapters.output.model.repository.entity.ModelEntity;
import br.com.jtech.services.togaf.adapters.adapters.output.project.repository.entity.ProjectEntity;
import br.com.jtech.services.togaf.core.application.domains.Phase;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Builder
@Entity
@Getter
@Setter
@Table(name = "phases")
@NoArgsConstructor
@AllArgsConstructor
public class PhaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "phase_id")
    private Long id;

    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @ManyToMany
    @JoinTable(name = "models_phases",
            joinColumns = @JoinColumn(name = "phase_id"),
            inverseJoinColumns = @JoinColumn(name = "model_id"))
    private Set<ModelEntity> models;

    @OneToMany(mappedBy = "phase")
    private List<CommentEntity> comments;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private ProjectEntity project;

    public static PhaseEntity fromDomain(Phase phase) {
        return PhaseEntity.builder()
                .id(phase.getId())
                .name(phase.getName())
                .description(phase.getDescription())
                .models(ModelEntity.fromDomains(phase.getModels()))
                .project(ProjectEntity.fromDomain(phase.getProject()))
                .build();
    }

    public static Set<PhaseEntity> fromDomains(Set<Phase> phases) {
        return phases.stream().map(PhaseEntity::fromDomain).collect(Collectors.toSet());
    }

    public static Set<Phase> toDomains(Set<PhaseEntity> phases) {
        return phases.stream().map(PhaseEntity::toDomain).collect(Collectors.toSet());
    }

    public Phase toDomain() {
        return Phase.builder()
                .id(id)
                .name(name)
                .description(description)
                .models(ModelEntity.toDomains(models))
                .project(project.toDomain())
                .comments(CommentEntity.toDomains(comments))
                .build();
    }
}
