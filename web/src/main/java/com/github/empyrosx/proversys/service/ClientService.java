package com.github.empyrosx.proversys.service;

import com.github.empyrosx.proversys.model.Client;

import java.util.List;

/**
 * Service for clients.
 */
public interface ClientService {

    /**
     * Returns all clients.
     */
    List<Client> findAll();

    /**
     * Adds new client.
     *
     * @param client client instance
     * @return
     */
    Client add(Client client);

    /**
     * Finds client by id.
     *
     * @param id client identifier
     * @return {@link Client}
     */
    Client findById(long id);

    /**
     * Deletes client by id.
     * @param id client identifier
     */
    void delete(long id);
}
