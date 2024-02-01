package br.com.jtech.services.togaf.core.application.core.domains;

import lombok.*;

import static java.util.Objects.nonNull;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Long id;
    private String username;
    private String password;
    private Role role;
    private String email;

    public boolean isValid() {
        return nonNull(getEmail())
                && isValidPass()
                && nonNull(getUsername());
    }

    public boolean isValidPass() {
        return nonNull(getPassword())
                && getPassword().length() > 6
                && getPassword().length() < 10;
    }

    public boolean isAdmin() {
        return getRole().equals(Role.ADMIN);
    }

}
