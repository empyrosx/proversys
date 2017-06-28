package com.github.empyrosx.proversys.rest;

import com.github.empyrosx.proversys.model.Project;
import com.github.empyrosx.proversys.service.ProjectService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static com.github.empyrosx.proversys.rest.JacksonMapper.toJson;
import static com.github.empyrosx.proversys.rest.ProjectRestController.REST_URL;
import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Tests for project rest controller.
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

        mockMvc.perform(get(REST_URL).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$[0].name").value("Web-consolidation"))
                .andExpect(jsonPath("$[1].name").value("Web-planning"));

        verify(service, times(1)).findAll();
        verifyNoMoreInteractions(service);
    }

    @Test
    public void projectMayBeAdded() throws Exception {
        Project added = new Project(1L, "Web-consolidation");
        when(service.add(any(Project.class))).thenReturn(added);

        Project dto = new Project("Web-consolidation");

        mockMvc.perform(post(REST_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(toJson(dto)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.id").value(added.getId()))
                .andExpect(jsonPath("$.name").value(added.getName()));

        ArgumentCaptor<Project> dtoCaptor = ArgumentCaptor.forClass(Project.class);
        verify(service, times(1)).add(dtoCaptor.capture());
        verifyNoMoreInteractions(service);

        Project dtoArgument = dtoCaptor.getValue();
        assertNull(dtoArgument.getId());
        assertThat(dtoArgument.getName(), is(dto.getName()));
    }
}
