package com.github.empyrosx.proversys.service;

import com.github.empyrosx.proversys.model.Project;

import java.util.List;

/**
 * Service for projects.
 */
public interface ProjectService {

    /**
     * Returns all projects.
     */
    List<Project> findAll();

    /**
     * Adds new project.
     * @param project project instance
     */
    Project add(Project project);
}
