package com.github.empyrosx.proversys.repository.jpa;

import com.github.empyrosx.proversys.model.ProjectVersion;
import com.github.empyrosx.proversys.repository.ProjectVersionRepository;
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
public class ProjectVersionRepositoryJPA implements ProjectVersionRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public ProjectVersion add(ProjectVersion version) {
        entityManager.persist(version);
        return version;
    }

    public ProjectVersion findByName(String name) {
        String qlString = "from ProjectVersion where name = :name";
        return entityManager.createQuery(qlString, ProjectVersion.class)
                .setParameter("name", name)
                .getSingleResult();
    }

    public List<ProjectVersion> findByProjectName(String projectName) {
        String qlString = "select v " +
                "from ProjectVersion v " +
                "join fetch v.project p " +
                "where p.name = :name";
        return entityManager.createQuery(qlString, ProjectVersion.class)
                .setParameter("name", projectName)
                .getResultList();
    }
}
