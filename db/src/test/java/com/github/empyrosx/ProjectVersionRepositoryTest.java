package com.github.empyrosx;

import com.github.empyrosx.proversys.model.Project;
import com.github.empyrosx.proversys.model.ProjectVersion;
import com.github.empyrosx.proversys.repository.ProjectRepository;
import com.github.empyrosx.proversys.repository.ProjectVersionRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.unitils.UnitilsJUnit4TestClassRunner;
import org.unitils.dbunit.annotation.DataSet;
import org.unitils.dbunit.annotation.ExpectedDataSet;
import org.unitils.reflectionassert.ReflectionAssert;
import org.unitils.spring.annotation.SpringApplicationContext;
import org.unitils.spring.annotation.SpringBeanByType;

import java.util.ArrayList;
import java.util.List;

/**
 * Project version repository tests.
 */
@RunWith(UnitilsJUnit4TestClassRunner.class)
@SpringApplicationContext({"database-context.xml", "database-test-context.xml"})
public class ProjectVersionRepositoryTest {

    @SpringBeanByType
    private ProjectRepository projectRepository;

    @SpringBeanByType
    private ProjectVersionRepository repository;

    @Test
    @DataSet
    @ExpectedDataSet
    public void projectVersionMayBeAdded() throws Exception {
        Project project = new Project("Web-consolidation");
        projectRepository.add(project);

        ProjectVersion version = new ProjectVersion("3.0");
        version.setProject(project);
        repository.add(version);
    }


    @Test
    @DataSet
    public void projectVersionMayBeFoundByName() throws Exception {
        String versionName = "3.0";
        ProjectVersion expected = new ProjectVersion(versionName);
        expected.setId(1);
        ReflectionAssert.assertReflectionEquals(expected, repository.findByName(versionName));
    }

    @Test
    @DataSet(value = "ProjectVersionRepositoryTest.projectVersionsMayBeFoundByProject.xml")
    public void projectVersionsMayBeFoundByProject() throws Exception {
        String projectName = "AS Consolidation";
        Project project = new Project(projectName).setId(1);

        List<ProjectVersion> expected = new ArrayList<ProjectVersion>();
        expected.add(new ProjectVersion("1.0").setId(10).setProject(project));
        expected.add(new ProjectVersion("2.0").setId(20).setProject(project));
        ReflectionAssert.assertReflectionEquals(expected, repository.findByProjectName(projectName));
    }

}
