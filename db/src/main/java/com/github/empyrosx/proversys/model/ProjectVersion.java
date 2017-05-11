package com.github.empyrosx.proversys.model;

import javax.persistence.*;

/**
 * Project version entity.
 */
@Entity
@Table(name = "project_version")
public class ProjectVersion {

    @Id
    @SequenceGenerator(name = "global_seq", sequenceName = "global_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "global_seq")
    private long id;

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
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public ProjectVersion setId(long id) {
        this.id = id;
        return this;
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
