package com.github.empyrosx.proversys.model;

import javax.persistence.*;

/**
 * Project version entity.
 */
@Entity
@Table(name = "project_version")
public class ProjectVersion extends BaseEntity {

    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "project_id")
    private Project project;

    /**
     * Default constructor.
     */
    public ProjectVersion() {
    }

    /**
     * Constructs new project version with given name.
     *
     * @param name version name
     */
    public ProjectVersion(String name) {
        this(0, name, null);
    }

    /**
     * Constructs new project version with given attributes.
     *
     * @param name version name
     */
    public ProjectVersion(long id, String name, Project project) {
        this.id = id;
        this.name = name;
        this.project = project;
    }

    public ProjectVersion(long id, String name) {
        this(id, name, null);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Project getProject() {
        return project;
    }

    public ProjectVersion setProject(Project project) {
        this.project = project;
        return this;
    }
}
