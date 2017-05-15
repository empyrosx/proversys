package com.github.empyrosx.proversys.model;

import javax.persistence.*;

/**
 * Client entity.
 */
@Entity
public class Client extends BaseEntity {

    private String name;

    /**
     * Default constructor.
     */
    public Client() {
    }

    /**
     * Constructs new client with given name.
     *
     * @param name client name
     */
    public Client(String name) {
        this(0, name);
    }

    /**
     * Constructs new client with given attributes.
     *
     * @param id client id
     * @param name client name
     */
    public Client(long id, String name) {
        this.id = id;
        this.name = name;
    }
}
