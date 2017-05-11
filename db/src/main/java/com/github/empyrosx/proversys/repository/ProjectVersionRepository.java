package com.github.empyrosx.proversys.repository;

import com.github.empyrosx.proversys.model.ProjectVersion;

import java.util.List;

/**
 * Project version repository.
 */
public interface ProjectVersionRepository {

    /**
     * Adds project version to repository.
     *
     * @param version version instance
     * @return added project version
     */
    ProjectVersion add(ProjectVersion version);

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
