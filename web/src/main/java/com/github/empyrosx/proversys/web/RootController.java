package com.github.empyrosx.proversys.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Root controller for main pages.
 */
@Controller
@RequestMapping
public class RootController {

    @RequestMapping(path = "/projectsList", method = RequestMethod.GET)
    public String getProjectsView() {
        return "projectsView";
    }

    @RequestMapping(path = "/clientsList", method = RequestMethod.GET)
    public String getClientsView() {
        return "clientsView";
    }

    @RequestMapping(path = "/clientProjectsList", method = RequestMethod.GET)
    public String getClientProjectsView() {
        return "clientProjectsView";
    }
}
