package com.github.empyrosx.proversys.web;

import com.github.empyrosx.proversys.model.Client;
import com.github.empyrosx.proversys.service.ClientService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * Ajax controller for clients.
 */
@RestController
@RequestMapping(path = "/clients")
public class ClientController {

    private ClientService service;

    public ClientController(ClientService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Client> findAll() {
        return service.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void addClient(Client client) {
        service.add(client);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Client get(@PathVariable("id") long id) {
        return service.findById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") long id) {
        service.delete(id);
    }
}
