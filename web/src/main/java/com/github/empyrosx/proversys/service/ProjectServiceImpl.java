package com.github.empyrosx.proversys.service;

import com.github.empyrosx.proversys.model.Project;
import com.github.empyrosx.proversys.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementation class for project service.
 */
@Service
public class ProjectServiceImpl implements ProjectService {

    private ProjectRepository repository;

    /**
     * Initialization constructor.
     * @param repository project repository
     */
    public ProjectServiceImpl(ProjectRepository repository) {
        this.repository = repository;
    }

    /**
     * Returns all projects.
     * @return
     */
    public List<Project> findAll() {
        return repository.findAll();
    }

    @Override
    public Project add(Project project) {
        return repository.save(project);
    }
}
