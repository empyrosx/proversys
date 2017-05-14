package com.github.empyrosx;

import com.github.database.rider.core.DBUnitRule;
import com.github.database.rider.core.api.connection.ConnectionHolder;
import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.core.api.dataset.ExpectedDataSet;
import com.github.empyrosx.proversys.model.Project;
import com.github.empyrosx.proversys.repository.ProjectRepository;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Connection;
import java.sql.SQLException;

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
    @ExpectedDataSet(value = "datasets/projectMayBeAdded.xml", ignoreCols = "id")
    public void projectMayBeAdded() throws Exception {
        Project project = new Project("Web-consolidation");
        assertNotNull(repository.add(project).getId());
    }

    @Test
    @DataSet(cleanBefore = true, value = "datasets/projectMayBeFoundByName.xml")
    public void projectMayBeFoundByName() throws Exception {
        String projectName = "Web-planning";
        Project expected = new Project(projectName);
        expected.setId(1);
        assertThat(repository.findByName(projectName), samePropertyValuesAs(expected));
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
    @Ignore
    public void projectMayBeDeleted() throws Exception {

    }
}
