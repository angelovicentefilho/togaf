package br.com.jtech.services.togaf.core.application.core.domains;

import lombok.*;

import java.util.Set;

import static java.util.Objects.nonNull;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Model {

    private Long id;
    private String name;
    private String description;

    private Set<Phase> phases;
    private Set<Project> projects;

    public boolean hasPhases() {
        return nonNull(getPhases()) && !getPhases().isEmpty();
    }
}
