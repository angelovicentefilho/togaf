package br.com.jtech.services.togaf.adapters.adapters.output.user.repository.entity;

import br.com.jtech.services.togaf.core.application.domains.Role;
import br.com.jtech.services.togaf.core.application.domains.User;
import jakarta.persistence.*;
import lombok.*;

@Builder
@Entity
@Getter
@Setter
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    private String username;
    private String password;
    private String role;
    private String email;

    public static UserEntity fromDomain(User user) {
        return UserEntity.builder()
                .id(user.getId())
                .username(user.getUsername())
                .password(user.getPassword())
                .role(user.getRole().name())
                .email(user.getEmail())
                .build();
    }

    public User toDomain() {
        return User.builder()
                .id(id)
                .username(username)
                .password(password)
                .role(Role.valueOf(role))
                .email(email)
                .build();
    }
}
