package br.com.jtech.services.togaf.adapters.adapters.output.model.repository.entity;

import br.com.jtech.services.togaf.adapters.adapters.output.phase.repository.entity.PhaseEntity;
import br.com.jtech.services.togaf.adapters.adapters.output.project.repository.entity.ProjectEntity;
import br.com.jtech.services.togaf.core.application.domains.Model;
import jakarta.persistence.*;
import lombok.*;
import java.util.*;
import java.util.stream.Collectors;

@Builder
@Entity
@Getter
@Setter
@Table(name = "models")
@NoArgsConstructor
@AllArgsConstructor
public class ModelEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "model_id")
    private Long id;

    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @ManyToMany(mappedBy = "models")
    private Set<PhaseEntity> phases;


    @OneToMany(mappedBy = "model")
    private Set<ProjectEntity> projects;

    public static ModelEntity fromDomain(Model model) {
        return ModelEntity.builder()
                .id(model.getId())
                .name(model.getName())
                .description(model.getDescription())
                .phases(PhaseEntity.fromDomains(model.getPhases()))
                .projects(ProjectEntity.fromDomains(model.getProjects()))
                .build();
    }

    public static Set<ModelEntity> fromDomains(Set<Model> models) {
        return models.stream().map(ModelEntity::fromDomain).collect(Collectors.toSet());
    }

    public static Set<Model> toDomains(Set<ModelEntity> models) {
        return models.stream().map(ModelEntity::toDomain).collect(Collectors.toSet());
    }

    public Model toDomain() {
        return Model.builder()
                .id(id)
                .name(name)
                .description(description)
                .phases(PhaseEntity.toDomains(phases))
                .projects(ProjectEntity.toDomains(projects))
                .build();
    }
}
