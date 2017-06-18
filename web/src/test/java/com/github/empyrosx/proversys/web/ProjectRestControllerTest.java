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

import static java.util.Arrays.asList;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Tests for project controller.
 */
@RunWith(MockitoJUnitRunner.class)
public class ProjectRestControllerTest {

    @Mock
    private ProjectService service;

    private MockMvc mockMvc;

    private List<Project> projects = asList(new Project("Web-consolidation"),
            new Project("Web-planning"));

    @Before
    public void init() {
        mockMvc = MockMvcBuilders
                .standaloneSetup(new ProjectRestController(service))
                .build();
    }

    @Test
    public void projectAreReturned() throws Exception {
        when(service.findAll()).thenReturn(projects);
        mockMvc.perform(get("/rest/projects").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("$[0].name").value("Web-consolidation"))
                .andExpect(jsonPath("$[1].name").value("Web-planning"));
    }
}
