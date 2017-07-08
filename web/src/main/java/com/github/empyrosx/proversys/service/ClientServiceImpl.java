package com.github.empyrosx.proversys.service;

import com.github.empyrosx.proversys.model.Client;
import com.github.empyrosx.proversys.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementation class for client service.
 */
@Service
public class ClientServiceImpl implements ClientService {

    private ClientRepository repository;

    /**
     * Initialization constructor.
     *
     * @param repository client repository
     */

    public ClientServiceImpl(ClientRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Client> findAll() {
        return repository.findAll();
    }

    @Override
    public Client add(Client client) {
        return repository.save(client);
    }

    @Override
    public Client findById(long id) {
        return repository.findOne(id);
    }

    @Override
    public void delete(long id) {
        repository.delete(id);
    }
}
