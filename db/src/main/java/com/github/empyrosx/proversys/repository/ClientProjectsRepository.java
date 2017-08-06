package com.github.empyrosx.proversys.repository;

import com.github.empyrosx.proversys.model.ClientProject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Client projects repository.
 */
@Repository
@Transactional(readOnly = true)
public interface ClientProjectsRepository extends JpaRepository<ClientProject, Long> {
}
