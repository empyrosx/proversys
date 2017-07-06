package com.github.empyrosx.proversys.web;

import com.github.empyrosx.proversys.model.Project;
import com.github.empyrosx.proversys.service.ProjectService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static com.github.empyrosx.proversys.rest.JacksonMapper.toJson;
import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Tests for project controller.
 */
@RunWith(MockitoJUnitRunner.class)
public class ProjectControllerTest {

    @Mock
    private ProjectService service;

    private MockMvc mockMvc;

    private ProjectController controller;

    private List<Project> projects = asList(
            new Project(1L,"Web-consolidation"),
            new Project(2L,"Web-planning"));

    @Before
    public void init() {
        controller = new ProjectController(service);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
        when(service.findAll()).thenReturn(projects);
        when(service.findById(1L)).thenReturn(projects.get(0));
        when(service.findById(2L)).thenReturn(projects.get(1));
    }

    @Test
    public void findAll() throws Exception {
        mockMvc.perform(get("/projects")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id").value(1L))
                .andExpect(jsonPath("$[0].name").value("Web-consolidation"))
                .andExpect(jsonPath("$[1].id").value(2L))
                .andExpect(jsonPath("$[1].name").value("Web-planning"));
    }

    @Test
    public void getProjectById() throws Exception {
        mockMvc.perform(get("/projects/1")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("id").value(1L))
                .andExpect(jsonPath("name").value("Web-consolidation"));
    }

    @Test
    public void deleteProjectById() throws Exception {
        mockMvc.perform(delete("/projects/1")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk());
        verify(service).delete(1L);
        verifyNoMoreInteractions(service);
    }

    @Test
    public void addProject() throws Exception {
        Project dto = new Project("Web-consolidation");

        mockMvc.perform(post("/projects")
                .contentType(MediaType.APPLICATION_JSON)
                .content(toJson(dto)))
                .andExpect(status().isFound())
                .andExpect(redirectedUrl("projectList"));

        verify(service).add(any(Project.class));
        verifyNoMoreInteractions(service);
    }
}
