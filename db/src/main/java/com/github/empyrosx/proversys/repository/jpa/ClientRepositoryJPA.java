package com.github.empyrosx.proversys.repository.jpa;

import com.github.empyrosx.proversys.model.Client;
import com.github.empyrosx.proversys.repository.ClientRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Client repository JPA implementation.
 */
@Repository
@Transactional(readOnly = true)
public class ClientRepositoryJPA implements ClientRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public Client add(Client client) {
        entityManager.persist(client);
        return client;
    }

    @Override
    public Client findByName(String name) {
        String qlString = "from Client  where name = :name";
        return entityManager.createQuery(qlString, Client.class)
                .setParameter("name", name)
                .getSingleResult();
    }
}
