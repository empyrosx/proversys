package com.github.empyrosx.proversys.repository.jpa;

import com.github.empyrosx.proversys.model.Project;
import com.github.empyrosx.proversys.repository.ProjectRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Project repository JPA implementation.
 */
@Repository
@Transactional(readOnly = true)
public class ProjectRepositoryJPA implements ProjectRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Project add(Project project) {
        entityManager.persist(project);
        return project;
    }

    public Project findByName(String projectName) {
        String qlString = "from Project where name = :name";
        return entityManager.createQuery(qlString, Project.class)
                .setParameter("name", projectName)
                .getSingleResult();
    }

    @Override
    public List<Project> findAll() {
        String qlString = "from Project";
        return entityManager.createQuery(qlString, Project.class)
                .getResultList();
    }
}
