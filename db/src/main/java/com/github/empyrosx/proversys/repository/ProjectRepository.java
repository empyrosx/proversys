package com.github.empyrosx.proversys.repository;

import com.github.empyrosx.proversys.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Project repository.
 */
@Repository
@Transactional(readOnly = true)
public interface ProjectRepository extends JpaRepository<Project, Long> {

    /**
     * Adds project to repository.
     *
     * @param project project instance
     * @return adder project
     */
    @Transactional
    Project save(Project project);

    /**
     * Finds project with given name.
     *
     * @param projectName project name
     */
    Project findByName(String projectName);
}
