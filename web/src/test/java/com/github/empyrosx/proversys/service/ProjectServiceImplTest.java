package com.github.empyrosx.proversys.service;

import com.github.empyrosx.proversys.model.Project;
import com.github.empyrosx.proversys.repository.ProjectRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

/**
 * Tests for project service.
 */
@RunWith(MockitoJUnitRunner.class)
public class ProjectServiceImplTest {

    @Mock
    private ProjectRepository repository;
    private ProjectService service;

    @Before
    public void init() {
        service = new ProjectServiceImpl(repository);
    }

    @Test
    public void findAll() throws Exception {
        Project first = new Project("Web-consolidation");
        Project second = new Project("Web-budget");
        when(repository.findAll()).thenReturn(asList(first, second));

        assertThat(service.findAll(), hasItems(first, second));
    }

    @Test
    public void projectMayBeAdded() throws Exception {
        Project addingProject = new Project("Web-consolidation");
        Project expected = new Project(1, "Web-consolidation");

        when(repository.save(addingProject)).thenReturn(expected);

        Project actual = service.add(addingProject);
        Assert.assertSame("Service doesn't return object from repository\n", actual, expected);

        verify(repository, only()).save(addingProject);
        verifyNoMoreInteractions(repository);
    }
}
