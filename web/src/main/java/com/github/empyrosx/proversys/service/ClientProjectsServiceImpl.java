package com.github.empyrosx.proversys.service;

import com.github.empyrosx.proversys.dto.ClientProjectDTO;
import com.github.empyrosx.proversys.model.Client;
import com.github.empyrosx.proversys.model.ClientProject;
import com.github.empyrosx.proversys.model.Project;
import com.github.empyrosx.proversys.repository.ClientProjectsRepository;
import com.github.empyrosx.proversys.repository.ClientRepository;
import com.github.empyrosx.proversys.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementation class for client projects service.
 */
@Service
public class ClientProjectsServiceImpl implements ClientProjectsService {

    private ClientRepository clientRepository;

    private ProjectRepository projectRepository;

    private ClientProjectsRepository repository;

    public ClientProjectsServiceImpl(ClientProjectsRepository repository, ClientRepository clientRepository,
                                     ProjectRepository projectRepository) {
        this.repository = repository;
        this.clientRepository = clientRepository;
        this.projectRepository = projectRepository;
    }

    @Override
    public List<ClientProject> findAll() {
        return repository.findAll();
    }

    @Override
    public ClientProject add(ClientProjectDTO clientProjectDTO) {
        Client client = clientRepository.getOne(clientProjectDTO.getClient());
        Project project = projectRepository.getOne(clientProjectDTO.getProject());
        ClientProject clientProject = new ClientProject(clientProjectDTO.getId(), client, project);
        return repository.save(clientProject);
    }

    @Override
    public ClientProjectDTO findById(long id) {
        ClientProject result = repository.findOne(id);
        return new ClientProjectDTO(result.getId(),
                result.getClient().getId(), result.getProject().getId());
    }

    @Override
    public void delete(long id) {
        repository.delete(id);
    }
}
