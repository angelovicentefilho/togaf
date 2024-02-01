package br.com.jtech.services.togaf.core.application.core.domains;

import lombok.*;

import java.time.LocalDate;

import static java.util.Objects.nonNull;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    private Long id;
    private String comment;
    private Project project;
    private Phase phase;
    private User user;
    private LocalDate createdAt;

    public boolean isComment() {
        return nonNull(getComment());
    }

    public boolean isValid() {
        return nonNull(getProject())
                && nonNull(getProject().getId())
                && nonNull(getUser())
                && nonNull(getUser().getId())
                && nonNull(getPhase())
                && nonNull(getPhase().getId())
                && isComment();
    }
}