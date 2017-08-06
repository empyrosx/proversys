package com.github.empyrosx.proversys.dto;

/**
 * Client project DTO.
 */
public class ClientProjectDTO {

    private long id;
    private long client;
    private long project;

    public ClientProjectDTO() {
    }

    public ClientProjectDTO(long client, long project) {
        this(0, client, project);
    }

    public ClientProjectDTO(long id, long client, long project) {
        this.id = id;
        this.client = client;
        this.project = project;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getClient() {
        return client;
    }

    public void setClient(long client) {
        this.client = client;
    }

    public long getProject() {
        return project;
    }

    public void setProject(long project) {
        this.project = project;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClientProjectDTO that = (ClientProjectDTO) o;

        if (client != that.client) return false;
        return project == that.project;
    }

    @Override
    public int hashCode() {
        int result = (int) (client ^ (client >>> 32));
        result = 31 * result + (int) (project ^ (project >>> 32));
        return result;
    }
}
