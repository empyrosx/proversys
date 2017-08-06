package com.github.empyrosx.proversys.service;

import com.github.empyrosx.proversys.dto.ClientProjectDTO;
import com.github.empyrosx.proversys.model.Client;
import com.github.empyrosx.proversys.model.ClientProject;
import com.github.empyrosx.proversys.model.Project;
import com.github.empyrosx.proversys.repository.ClientProjectsRepository;
import com.github.empyrosx.proversys.repository.ClientRepository;
import com.github.empyrosx.proversys.repository.ProjectRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.util.ReflectionUtils;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

/**
 * Tests for client projects service.
 */
@RunWith(MockitoJUnitRunner.class)
public class ClientProjectsServiceImplTest {

    @Mock
    private ClientProjectsRepository repository;

    @Mock
    private ClientRepository clientsRepository;

    @Mock
    private ProjectRepository projectsRepository;

    private ClientProjectsService service;

    @Before
    public void init() {
        service = new ClientProjectsServiceImpl(repository, clientsRepository, projectsRepository);
    }

    @Test
    public void findAll() {
        Client firstClient = new Client("Yaroslavl");
        Client secondClient = new Client("Vologda");

        Project firstProject = new Project("Web-consolidation");
        Project secondProject = new Project("Web-planning");

        ClientProject first = new ClientProject(firstClient, firstProject);
        ClientProject second = new ClientProject(secondClient, secondProject);
        when(repository.findAll()).thenReturn(asList(first, second));

        assertThat(service.findAll(), hasItems(first, second));
    }

    @Test
    public void add() {
        ClientProjectDTO addingClientProject = new ClientProjectDTO(1L, 2L);

        service.add(addingClientProject);

        verify(clientsRepository).getOne(addingClientProject.getClient());
        verify(projectsRepository).getOne(addingClientProject.getProject());
        verify(repository).save(any(ClientProject.class));
        verifyNoMoreInteractions(repository, clientsRepository, projectsRepository);
    }

    @Test
    public void findBy() {
        Client firstClient = new Client(1L, "Yaroslavl");

        Project firstProject = new Project(2L,"Web-consolidation");

        ClientProject first = new ClientProject(firstClient, firstProject);
        when(repository.findOne(1L)).thenReturn(first);

        ClientProjectDTO expected = new ClientProjectDTO(first.getId(),
                first.getClient().getId(), first.getProject().getId());
        assertEquals(service.findById(1L), expected);
    }
}
