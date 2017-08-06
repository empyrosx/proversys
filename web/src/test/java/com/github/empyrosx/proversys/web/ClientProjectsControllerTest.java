package com.github.empyrosx.proversys.web;

import com.github.empyrosx.proversys.dto.ClientProjectDTO;
import com.github.empyrosx.proversys.model.Client;
import com.github.empyrosx.proversys.model.ClientProject;
import com.github.empyrosx.proversys.model.Project;
import com.github.empyrosx.proversys.service.ClientProjectsService;
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
 * Tests for client projects controller.
 */
@RunWith(MockitoJUnitRunner.class)
public class ClientProjectsControllerTest {

    @Mock
    private ClientProjectsService service;

    private MockMvc mockMvc;

    private List<ClientProject> clients = asList(
            new ClientProject(1L, new Client(3L,"Vologda"), new Project(4L,"Web-consolidation")),
            new ClientProject(2L, new Client(5L, "Yaroslavl"), new Project(6L, "Web-planning")));

    @Before
    public void init() {
        ClientProjectsController controller = new ClientProjectsController(service);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
        when(service.findAll()).thenReturn(clients);
        when(service.findById(1L)).thenReturn(toDTO(clients.get(0)));
    }

    private ClientProjectDTO toDTO(ClientProject clientProject) {
        return new ClientProjectDTO(clientProject.getId(),
                clientProject.getClient().getId(),
                clientProject.getProject().getId());
    }

    @Test
    public void findAll() throws Exception {
        mockMvc.perform(get("/clientProjects")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id").value(1L))
                .andExpect(jsonPath("$[0].client.name").value("Vologda"))
                .andExpect(jsonPath("$[0].project.name").value("Web-consolidation"))
                .andExpect(jsonPath("$[1].id").value(2L))
                .andExpect(jsonPath("$[1].client.name").value("Yaroslavl"))
                .andExpect(jsonPath("$[1].project.name").value("Web-planning"));
    }

    @Test
    public void addClientProject() throws Exception {
        ClientProjectDTO dto = new ClientProjectDTO(1L, 2L);

        mockMvc.perform(post("/clientProjects")
                .contentType(MediaType.APPLICATION_JSON)
                .content(toJson(dto)))
                .andExpect(status().isOk());

        verify(service).add(any(ClientProjectDTO.class));
        verifyNoMoreInteractions(service);
    }

    @Test
    public void getClientProject() throws Exception {
        mockMvc.perform(get("/clientProjects/1")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.client").value("3"))
                .andExpect(jsonPath("$.project").value("4"));

        verify(service).findById(1L);
        verifyNoMoreInteractions(service);
    }

    @Test
    public void deleteClientProject() throws Exception {
        mockMvc.perform(delete("/clientProjects/1")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk());

        verify(service).delete(1);
        verifyNoMoreInteractions(service);
    }
}
