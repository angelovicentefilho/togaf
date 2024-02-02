package br.com.jtech.services.togaf.core.application.domains;

import lombok.*;

import java.util.Set;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Phase {

    private Long id;
    private String name;
    private String description;
    private Project project;

    private Set<Attach> attaches;
    private Set<Model> models;
    private Set<Comment> comments;


}
