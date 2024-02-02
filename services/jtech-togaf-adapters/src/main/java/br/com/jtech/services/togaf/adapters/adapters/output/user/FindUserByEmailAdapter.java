package br.com.jtech.services.togaf.adapters.adapters.output.user;

import br.com.jtech.services.togaf.adapters.adapters.output.user.repository.UserRepository;
import br.com.jtech.services.togaf.adapters.adapters.output.user.repository.entity.UserEntity;
import br.com.jtech.services.togaf.core.application.domains.User;
import br.com.jtech.services.togaf.core.application.usecases.user.ports.output.FindUserByEmailOutputGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FindUserByEmailAdapter implements FindUserByEmailOutputGateway {

    private final UserRepository repository;

    @Override
    @Cacheable(value = "users", key = "#email")
    public Optional<User> findByEmail(String email) {
        return repository.findByEmail(email).map(UserEntity::toDomain);
    }
}
