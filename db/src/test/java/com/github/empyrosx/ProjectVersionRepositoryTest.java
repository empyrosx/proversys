package com.github.empyrosx;

import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.core.api.dataset.ExpectedDataSet;
import com.github.empyrosx.proversys.model.Project;
import com.github.empyrosx.proversys.model.ProjectVersion;
import com.github.empyrosx.proversys.repository.ProjectRepository;
import com.github.empyrosx.proversys.repository.ProjectVersionRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.samePropertyValuesAs;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

/**
 * Project version repository tests.
 */
public class ProjectVersionRepositoryTest extends AbstractDaoTest {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private ProjectVersionRepository repository;

    @Test
    @DataSet(value = "datasets/projectVersion_add.xml", cleanBefore = true)
    @ExpectedDataSet(value = "datasets/projectVersion_add-result.xml", ignoreCols = "id")
    public void add() throws Exception {
        Project project = projectRepository.findByName("Web-consolidation");
        ProjectVersion version = new ProjectVersion("3.0");
        version.setProject(project);
        assertNotNull(repository.save(version).getId());
    }

    @Test
    @DataSet(cleanBefore = true, value = "datasets/projectVersion_foundByName.xml")
    public void foundByName() throws Exception {
        String versionName = "3.0";
        ProjectVersion expected = new ProjectVersion(1, versionName);
        assertThat(repository.findByName(versionName), samePropertyValuesAs(expected));
    }

    @Test
    @DataSet(value = "datasets/projectVersion_foundByProject.xml")
    public void foundByProject() throws Exception {
        String projectName = "AS Consolidation";
        Project project = new Project(1, projectName);

        List<ProjectVersion> expected = new ArrayList<>();
        expected.add(new ProjectVersion(10, "1.0", project));
        expected.add(new ProjectVersion(20, "2.0", project));
        assertThat(repository.findByProjectName(projectName), samePropertyValuesAs(expected));
    }
}
