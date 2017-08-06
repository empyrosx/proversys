package com.github.empyrosx;

import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.core.api.dataset.ExpectedDataSet;
import com.github.empyrosx.proversys.model.Client;
import com.github.empyrosx.proversys.model.ClientProject;
import com.github.empyrosx.proversys.model.Project;
import com.github.empyrosx.proversys.repository.ClientProjectsRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertNotNull;

/**
 * Client projects repository tests.
 */
public class ClientProjectsRepositoryTest extends AbstractDaoTest {

    @Autowired
    private ClientProjectsRepository repository;

    @Test
    @DataSet(cleanBefore = true, value = "datasets/client_project_add.xml")
    @ExpectedDataSet(value = "datasets/client_project_add-result.xml", ignoreCols = "id")
    public void add() throws Exception {
        Client client = new Client(1L, "Yaroslavl");
        Project project = new Project(2L, "Web-consolidation");
        ClientProject clientProject = new ClientProject(client, project);
        assertNotNull(repository.save(clientProject).getId());
    }

    @Test
    @DataSet(cleanBefore = true, value = "datasets/client_project_delete.xml")
    @ExpectedDataSet(value = "datasets/client_project_delete-result.xml", ignoreCols = "id")
    public void delete() throws Exception {
        repository.delete(2L);
    }
}
