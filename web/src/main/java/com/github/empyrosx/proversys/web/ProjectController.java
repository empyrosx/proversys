package com.github.empyrosx.proversys.web;

import com.github.empyrosx.proversys.model.Project;
import com.github.empyrosx.proversys.service.ProjectService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Ajax controller for projects.
 */
@Controller
@RequestMapping(path = "/projects")
public class ProjectController {

    private ProjectService service;

    public ProjectController(ProjectService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String findAll(Model model) {
        model.addAttribute("projects", service.findAll());
        return "projectsView";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String addProject(Project project) {
        service.add(project);
        return "redirect:projects";
    }

}
