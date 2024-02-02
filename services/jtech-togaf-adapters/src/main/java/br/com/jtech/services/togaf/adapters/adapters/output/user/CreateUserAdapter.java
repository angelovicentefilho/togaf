package br.com.jtech.services.togaf.adapters.adapters.output.user;

import br.com.jtech.services.togaf.adapters.adapters.output.user.repository.UserRepository;
import br.com.jtech.services.togaf.core.application.domains.User;
import br.com.jtech.services.togaf.core.application.usecases.user.ports.output.CreateUserOutputGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static br.com.jtech.services.togaf.adapters.adapters.output.user.repository.entity.UserEntity.fromDomain;

@Service
@RequiredArgsConstructor
public class CreateUserAdapter implements CreateUserOutputGateway {

    private final UserRepository repository;

    @Override
    @CachePut(value = "users", key = "#user.id")
    public Optional<User> create(User user) {
        return Optional.of(this.repository.save(fromDomain(user)).toDomain());
    }
}
