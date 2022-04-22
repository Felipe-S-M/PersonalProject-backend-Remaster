package com.fixingsolutions.employee.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "employee")
@Data
public class Employee {

    @Id
    private Integer id;

    @Version
    private Integer version;

    private String username;
    private String password;
    private String name;

    @ManyToMany
    @JoinTable(
            name = "authorities_employee",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "authority_id"))
    private List<Authority> authorities;
}
