package com.github.empyrosx.proversys.repository;

import com.github.empyrosx.proversys.model.Project;

/**
 * Project repository.
 */
public interface ProjectRepository {

    /**
     * Adds project to repository.
     *
     * @param project project instance
     * @return adder project
     */
    Project add(Project project);

    /**
     * Finds project with given name.
     *
     * @param projectName project name
     */
    Project findByName(String projectName);
}