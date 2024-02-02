package br.com.jtech.services.togaf.adapters.adapters.output.comment.repository;

import br.com.jtech.services.togaf.adapters.adapters.output.comment.repository.entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface CommentRepository extends JpaRepository<CommentEntity, Long> {

    Optional<CommentEntity> findByUserIdAndPhaseIdAndCreatedAt(Long userId, Long phaseId, LocalDate createdAt);

}
