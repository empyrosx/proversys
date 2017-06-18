package com.github.empyrosx.proversys.web;

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
public class ProjectAjaxController {

    private ProjectService service;

    public ProjectAjaxController(ProjectService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String findAll(Model model) {
        model.addAttribute("projectList", service.findAll());
        return "projectList";
    }
}
