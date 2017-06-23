package com.github.empyrosx.proversys.repository;

import com.github.empyrosx.proversys.model.ProjectVersion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Project version repository.
 */
@Repository
@Transactional(readOnly = true)
public interface ProjectVersionRepository extends JpaRepository<ProjectVersion, Long> {

    /**
     * Adds project version to repository.
     *
     * @param version version instance
     * @return added project version
     */
    @Transactional
    ProjectVersion save(ProjectVersion version);

    /**
     * Finds project version with given name.
     *
     * @param name version name
     */
    ProjectVersion findByName(String name);

    /**
     * Finds all project versions.
     *
     * @param projectName project name
     */
    List<ProjectVersion> findByProjectName(String projectName);
}
