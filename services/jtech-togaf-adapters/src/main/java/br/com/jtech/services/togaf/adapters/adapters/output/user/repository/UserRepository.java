package br.com.jtech.services.togaf.adapters.adapters.output.user.repository;

import br.com.jtech.services.togaf.adapters.adapters.output.user.repository.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByEmail(String email);
}
