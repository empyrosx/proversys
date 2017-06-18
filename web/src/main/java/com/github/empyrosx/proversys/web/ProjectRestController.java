package com.github.empyrosx.proversys.web;

import com.github.empyrosx.proversys.model.Project;
import com.github.empyrosx.proversys.service.ProjectService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Rest controller for projects.
 */
@RestController
@RequestMapping(path = "/rest/projects")
public class ProjectRestController {

    private ProjectService service;

    public ProjectRestController(ProjectService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Project> findAll() {
        return service.findAll();
    }
}
