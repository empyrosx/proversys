package com.github.empyrosx;

import com.github.empyrosx.proversys.model.Project;
import com.github.empyrosx.proversys.repository.ProjectRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.unitils.UnitilsJUnit4TestClassRunner;
import org.unitils.dbunit.annotation.ExpectedDataSet;
import org.unitils.spring.annotation.SpringApplicationContext;
import org.unitils.spring.annotation.SpringBeanByType;

import static org.junit.Assert.assertNotNull;

/**
 * Project repository tests.
 */
@RunWith(UnitilsJUnit4TestClassRunner.class)
@SpringApplicationContext({"database-context.xml", "database-test-context.xml"})
public class ProjectRepositoryTest {

    @SpringBeanByType
    private ProjectRepository repository;

    @Test
    @ExpectedDataSet
    public void projectIsAdded() throws Exception {
        Project project = new Project("Web-consolidation");
        assertNotNull(repository.addProject(project).getId());
    }
}
