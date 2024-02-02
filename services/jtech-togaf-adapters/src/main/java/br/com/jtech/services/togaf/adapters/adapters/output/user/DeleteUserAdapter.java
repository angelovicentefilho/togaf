package br.com.jtech.services.togaf.adapters.adapters.output.user;

import br.com.jtech.services.togaf.adapters.adapters.output.user.repository.UserRepository;
import br.com.jtech.services.togaf.core.application.domains.User;
import br.com.jtech.services.togaf.core.application.usecases.user.ports.output.DeleteUserOutputGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteUserAdapter implements DeleteUserOutputGateway {

    private final UserRepository repository;

    @Override
    @CacheEvict(value = "users", key = "#user.id")
    public void delete(User user) {
        repository.deleteById(user.getId());
    }
}
