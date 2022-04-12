package com.fixingsolutions.employee.entity;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Authority implements GrantedAuthority {
    @Id
    private Long id;

    private String authority;

    @ManyToMany
    @JoinTable(
            name = "authorities_employee",
            joinColumns = @JoinColumn(name = "authority"))
    private List<Employee> employee;
}
