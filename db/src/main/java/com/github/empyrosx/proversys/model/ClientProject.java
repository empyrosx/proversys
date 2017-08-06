package com.github.empyrosx.proversys.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Client project entity.
 */
@Entity
@Table(name = "client_project")
public class ClientProject extends BaseEntity {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "project_id")
    private Project project;

    public ClientProject() {
    }

    public ClientProject(Client client, Project project) {
        this(0, client, project);
    }

    public ClientProject(long id, Client client, Project project) {
        this.id = id;
        this.client = client;
        this.project = project;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
