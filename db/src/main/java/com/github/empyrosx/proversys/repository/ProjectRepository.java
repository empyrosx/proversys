package com.github.empyrosx.proversys.repository;

import com.github.empyrosx.proversys.model.Project;

/**
 * Project repository.
 */
public interface ProjectRepository {

    /**
     * Adds project to repository.
     * @param project project instance
     * @return adder project
     */
    Project addProject(Project project);
}
