package com.github.empyrosx.proversys.service;

import com.github.empyrosx.proversys.dto.ClientProjectDTO;
import com.github.empyrosx.proversys.model.ClientProject;

import java.util.List;

/**
 * Service for client projects.
 */
public interface ClientProjectsService {

    /**
     * Returns all client projects.
     */
    List<ClientProject> findAll();

    /**
     * Adds client project.
     * @param clientProjectDTO client project dto
     */
    ClientProject add(ClientProjectDTO clientProjectDTO);

    /**
     * Finds client project by id.
     * @param id client project identifier
     * @return {@link ClientProject}
     */
    ClientProjectDTO findById(long id);

    /**
     * Delete client project by id.
     * @param id client project identifier
     */
    void delete(long id);
}
