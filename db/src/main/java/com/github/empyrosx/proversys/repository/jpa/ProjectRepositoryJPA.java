package com.github.empyrosx.proversys.repository.jpa;

import com.github.empyrosx.proversys.model.Project;
import com.github.empyrosx.proversys.repository.ProjectRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Project repository JPA implementation.
 */
@Repository
@Transactional(readOnly = true)
public class ProjectRepositoryJPA implements ProjectRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Project addProject(Project project) {
        entityManager.persist(project);
        return project;
    }
}
