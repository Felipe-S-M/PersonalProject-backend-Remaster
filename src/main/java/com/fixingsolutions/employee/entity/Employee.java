package com.fixingsolutions.employee.entity;

import com.fixingsolutions.ocupation.entity.Ocupation;

import javax.persistence.*;

@Entity
public class Employee {

    @Id
    private Long id;

    @Version
    private Integer version;

    private String email;
    private String password;
    private String name;

    @ManyToOne
    private Ocupation ocupation;
}
