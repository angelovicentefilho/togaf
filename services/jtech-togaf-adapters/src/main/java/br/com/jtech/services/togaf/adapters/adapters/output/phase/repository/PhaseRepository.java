package br.com.jtech.services.togaf.adapters.adapters.output.phase.repository;

import br.com.jtech.services.togaf.adapters.adapters.output.phase.repository.entity.PhaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PhaseRepository extends JpaRepository<PhaseEntity, Long> {
    Optional<PhaseEntity> findByName(String name);
}
