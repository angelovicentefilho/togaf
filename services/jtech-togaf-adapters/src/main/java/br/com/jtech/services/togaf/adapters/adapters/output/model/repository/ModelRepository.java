package br.com.jtech.services.togaf.adapters.adapters.output.model.repository;

import br.com.jtech.services.togaf.adapters.adapters.output.model.repository.entity.ModelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ModelRepository extends JpaRepository<ModelEntity, Long> {
    Optional<ModelEntity> findByName(String name);
}
