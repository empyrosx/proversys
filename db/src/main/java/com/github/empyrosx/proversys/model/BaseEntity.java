package com.github.empyrosx.proversys.model;

import javax.persistence.*;

/**
 * Base entity.
 */
@MappedSuperclass
public class BaseEntity {

    @Id
    @SequenceGenerator(name = "global_seq", sequenceName = "global_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "global_seq")
    protected long id;

    public long getId() {
        return id;
    }

    public BaseEntity setId(long id) {
        this.id = id;
        return this;
    }
}
