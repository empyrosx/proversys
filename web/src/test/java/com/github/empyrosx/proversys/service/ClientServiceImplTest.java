package com.github.empyrosx.proversys.service;

import com.github.empyrosx.proversys.model.Client;
import com.github.empyrosx.proversys.repository.ClientRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

/**
 * Tests for client service.
 */
@RunWith(MockitoJUnitRunner.class)
public class ClientServiceImplTest {

    @Mock
    private ClientRepository repository;

    private ClientService service;

    @Before
    public void init() {
        service = new ClientServiceImpl(repository);
    }

    @Test
    public void findAll() {
        Client first = new Client("Vologda");
        Client second = new Client("Yaroslavl");
        when(repository.findAll()).thenReturn(asList(first, second));

        assertThat(service.findAll(), hasItems(first, second));
    }

    @Test
    public void add() {
        Client addingClient = new Client("Yaroslavl");
        Client expected = new Client(1L, "Yaroslavl");

        when(repository.save(addingClient)).thenReturn(expected);

        Client actual = service.add(addingClient);
        assertSame("Service doesn't return object from repository\n", actual, expected);

        verify(repository, only()).save(addingClient);
        verifyNoMoreInteractions(repository);
    }

    @Test
    public void findById() {
        Client expected = new Client("Yaroslavl");
        when(repository.findOne(1L)).thenReturn(expected);

        assertSame(service.findById(1L), expected);

        verify(repository, only()).findOne(1L);
        verifyNoMoreInteractions(repository);
    }

    @Test
    public void delete() {
        service.delete(1L);

        verify(repository).delete(1L);
        verifyNoMoreInteractions(repository);
    }
}
