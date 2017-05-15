package com.github.empyrosx.proversys.model;

import javax.persistence.*;

/**
 * Project entity.
 */
@Entity
public class Project extends BaseEntity {

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
        this(0, name);
    }

    /**
     * Constructs new project with given id and name.
     *
     * @param id project id
     * @param name project name
     */
    public Project(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
