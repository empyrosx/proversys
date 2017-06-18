package com.github.empyrosx.proversys.service;

import com.github.empyrosx.proversys.model.Project;
import com.github.empyrosx.proversys.repository.ProjectRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.Matchers.notNull;
import static org.mockito.Mockito.when;

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
}
