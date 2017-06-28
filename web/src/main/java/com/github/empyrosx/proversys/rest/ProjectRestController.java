package com.github.empyrosx.proversys.rest;

import com.github.empyrosx.proversys.model.Project;
import com.github.empyrosx.proversys.service.ProjectService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.github.empyrosx.proversys.rest.ProjectRestController.REST_URL;

/**
 * Rest controller for projects.
 */
@RestController
@RequestMapping(path = REST_URL)
public class ProjectRestController {

    public static final String REST_URL = "/rest/projects";

    private ProjectService service;

    public ProjectRestController(ProjectService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Project> findAll() {
        return service.findAll();
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Project add(@RequestBody Project project) {
        return service.add(project);
    }
}
