package com.github.empyrosx.proversys.model;

import javax.persistence.*;

/**
 * Project entity.
 */
@Entity
public class Project {

    @Id
    @SequenceGenerator(name = "global_seq", sequenceName = "global_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "global_seq")
    private long id;
    private String name;

    /**
     * Default constructor.
     */
    public Project() {
    }

    /**
     * Constructs new project with given name.
     *
     * @param name project name
     */
    public Project(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
