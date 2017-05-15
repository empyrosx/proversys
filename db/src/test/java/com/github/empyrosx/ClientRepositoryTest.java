package com.github.empyrosx;

import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.core.api.dataset.ExpectedDataSet;
import com.github.empyrosx.proversys.model.Client;
import com.github.empyrosx.proversys.repository.ClientRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.Matchers.samePropertyValuesAs;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

/**
 * Client repository tests.
 */
public class ClientRepositoryTest extends AbstractDaoTest {

    @Autowired
    private ClientRepository repository;

    @Test
    @DataSet(cleanBefore = true)
    @ExpectedDataSet(value = "datasets/clientMayBeAdded.xml", ignoreCols = "id")
    public void clientMayBeAdded() throws Exception {
        Client client = new Client("Yaroslavl");
        assertNotNull(repository.add(client).getId());
    }

    @Test
    @DataSet(cleanBefore = true, value = "datasets/clientMayBeFoundByName.xml")
    public void projectMayBeFoundByName() throws Exception {
        String clientName = "Vologda";
        Client expected = new Client(1, clientName);
        assertThat(repository.findByName(clientName), samePropertyValuesAs(expected));
    }
}
