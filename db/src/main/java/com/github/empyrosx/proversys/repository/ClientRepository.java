package com.github.empyrosx.proversys.repository;

import com.github.empyrosx.proversys.model.Client;

/**
 * Client repository.
 */
public interface ClientRepository {

    /**
     * Adds project to repository.
     *
     * @param client client instance
     * @return adder client
     */
    Client add(Client client);

    /**
     * Finds client with given name.
     *
     * @param name client name
     */
    Client findByName(String name);
}
