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
public class Project {

    private Long id;
    private String name;
    private String description;
    private Model model;
    private Phase phase;
    private Set<Comment> comments;

    public boolean isValid() {
        return nonNull(id)
                && nonNull(name)
                && nonNull(model);
    }
}
