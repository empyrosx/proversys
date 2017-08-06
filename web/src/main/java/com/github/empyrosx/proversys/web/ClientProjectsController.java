package com.github.empyrosx.proversys.web;

import com.github.empyrosx.proversys.dto.ClientProjectDTO;
import com.github.empyrosx.proversys.model.ClientProject;
import com.github.empyrosx.proversys.service.ClientProjectsService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * Controller for client projects.
 */
@RestController
@RequestMapping(path = "/clientProjects")
public class ClientProjectsController {

    private ClientProjectsService service;

    public ClientProjectsController(ClientProjectsService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<ClientProject> findAll() {
        return service.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void addClientProject(ClientProjectDTO clientProjectDTO) {
        service.add(clientProjectDTO);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ClientProjectDTO get(@PathVariable("id") long id) {
        return service.findById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") long id) {
        service.delete(id);
    }
}
