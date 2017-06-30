package com.github.empyrosx.proversys.web;

import com.github.empyrosx.proversys.model.Project;
import com.github.empyrosx.proversys.service.ProjectService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.collection.IsMapContaining.hasEntry;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Tests for project controller.
 */
@RunWith(MockitoJUnitRunner.class)
public class ProjectControllerTest {

    @Mock
    private ProjectService service;

    private MockMvc mockMvc;

    private ProjectController controller;

    private List<Project> projects = asList(new Project("Web-consolidation"),
            new Project("Web-planning"));

    @Before
    public void init() {
        controller = new ProjectController(service);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
        when(service.findAll()).thenReturn(projects);
    }

    @Test
    public void allProjectsAreAddedToModelForProjectsView() {
        Model model = new ExtendedModelMap();
        assertThat(controller.findAll(model), equalTo("projects"));
        assertThat(model.asMap(), hasEntry("projects", projects));
    }

    @Test
    public void requestForAddingNewProjectIsAvailable() throws Exception {
        this.mockMvc.perform(post("/projects"))
                .andExpect(status().isFound())
                .andExpect(redirectedUrl("projects"));
    }
}
