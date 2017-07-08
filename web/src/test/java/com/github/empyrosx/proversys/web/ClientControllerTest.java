package com.github.empyrosx.proversys.web;

import com.github.empyrosx.proversys.model.Client;
import com.github.empyrosx.proversys.service.ClientService;
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
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Tests for client controller.
 */
@RunWith(MockitoJUnitRunner.class)
public class ClientControllerTest {

    @Mock
    private ClientService service;

    private MockMvc mockMvc;

    private ClientController controller;

    private List<Client> clients = asList(
            new Client(1L, "Vologda"),
            new Client(2L, "Yaroslavl"));

    @Before
    public void init() {
        controller = new ClientController(service);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
        when(service.findAll()).thenReturn(clients);
        when(service.findById(1L)).thenReturn(clients.get(0));
        when(service.findById(2L)).thenReturn(clients.get(1));
    }

    @Test
    public void findAll() throws Exception {
        mockMvc.perform(get("/clients")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id").value(1L))
                .andExpect(jsonPath("$[0].name").value("Vologda"))
                .andExpect(jsonPath("$[1].id").value(2L))
                .andExpect(jsonPath("$[1].name").value("Yaroslavl"));
    }

    @Test
    public void getProjectById() throws Exception {
        mockMvc.perform(get("/clients/1")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("id").value(1L))
                .andExpect(jsonPath("name").value("Vologda"));
    }

    @Test
    public void deleteProjectById() throws Exception {
        mockMvc.perform(delete("/clients/1")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk());
        verify(service).delete(1L);
        verifyNoMoreInteractions(service);
    }

    @Test
    public void addProject() throws Exception {
        Client dto = new Client("Yaroslavl");

        mockMvc.perform(post("/clients")
                .contentType(MediaType.APPLICATION_JSON)
                .content(toJson(dto)))
                .andExpect(status().isOk());

        verify(service).add(any(Client.class));
        verifyNoMoreInteractions(service);
    }
}
