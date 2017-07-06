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

    /**
     * Finds project by id.
     * @param id project identifier
     * @return {@link Project}
     */
    Project findById(long id);

    /**
     * Deletes project by id.
     * @param id project identifier
     */
    void delete(long id);
}
