package br.com.jtech.services.togaf.adapters.adapters.output.project.repository;

import br.com.jtech.services.togaf.adapters.adapters.output.project.repository.entity.ProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<ProjectEntity, Long> {
}
