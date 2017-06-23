package com.github.empyrosx.proversys.repository;

import com.github.empyrosx.proversys.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Client repository.
 */
@Repository
@Transactional(readOnly = true)
public interface ClientRepository extends JpaRepository<Client, Long> {

    /**
     * Adds project to repository.
     *
     * @param client client instance
     * @return adder client
     */
    @Transactional
    Client save(Client client);

    /**
     * Finds client with given name.
     *
     * @param name client name
     */
    Client findByName(String name);
}
