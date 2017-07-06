package com.github.empyrosx;

import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.core.api.dataset.ExpectedDataSet;
import com.github.empyrosx.proversys.model.Project;
import com.github.empyrosx.proversys.repository.ProjectRepository;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.samePropertyValuesAs;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

/**
 * Project repository tests.
 */
public class ProjectRepositoryTest extends AbstractDaoTest {

    @Autowired
    private ProjectRepository repository;

    @Test
    @DataSet(cleanBefore = true)
    @ExpectedDataSet(value = "datasets/project_add-result.xml", ignoreCols = "id")
    public void add() throws Exception {
        Project project = new Project("Web-consolidation");
        assertNotNull(repository.save(project).getId());
    }

    @Test
    @DataSet(cleanBefore = true, value = "datasets/project_foundBy.xml")
    public void foundByName() throws Exception {
        String projectName = "Web-planning";
        Project expected = new Project(1L, projectName);
        assertThat(repository.findByName(projectName), samePropertyValuesAs(expected));
    }

    @Test
    @DataSet(cleanBefore = true, value = "datasets/project_All.xml")
    public void foundAll() throws Exception {
        List<Project> expected = new ArrayList<>();
        expected.add(new Project("Web-planning"));
        expected.add(new Project("Web-consolidation"));
        expected.add(new Project("Web-budget"));
        assertThat(repository.findAll(), samePropertyValuesAs(expected));
    }

    @Test
    @DataSet(cleanBefore = true, value = "datasets/project_foundBy.xml")
    public void foundByID() throws Exception {
        Long projectID = 1L;
        Project expected = new Project(projectID, "Web-planning");
        assertThat(repository.findOne(projectID), samePropertyValuesAs(expected));
    }

    @Test
    @Ignore
    public void projectNameMustBeUnique() {
    }

    @Test
    @Ignore
    public void isThereIsNoProjectWithSuchNameEmptyListIsReturned() throws Exception {
    }

    @Test
    @Ignore
    public void projectMayBeChanged() throws Exception {
    }

    @Test
    @DataSet(cleanBefore = true, value = "datasets/project_All.xml")
    @ExpectedDataSet(value = "datasets/project_delete-result.xml", ignoreCols = "id")
    public void projectMayBeDeleted() throws Exception {
        repository.delete(3L);
    }
}
