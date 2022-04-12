package com.fixingsolutions.employee.entity;

import com.fixingsolutions.ocupation.entity.Ocupation;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Employee {

    @Id
    private Long id;

    @Version
    private Integer version;

    private String username;
    private String password;
    private String name;

    @ManyToMany
    @JoinTable(
            name = "authorities_employee",
            joinColumns = @JoinColumn(name = "username"))
    private List<Authority> authorities;

    @ManyToOne
    private Ocupation ocupation;
}
