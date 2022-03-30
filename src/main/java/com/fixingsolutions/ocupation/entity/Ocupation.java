package com.fixingsolutions.ocupation.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Version;

@Entity
public class Ocupation {
    @Id
    private Long id;
    @Version
    private Integer version;

    private String name;
}
