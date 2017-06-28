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
        this(null, name);
    }

    /**
     * Constructs new project with given id and name.
     *
     * @param id project id
     * @param name project name
     */
    public Project(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Project{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
