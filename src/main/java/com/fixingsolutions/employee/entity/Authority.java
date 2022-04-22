package com.fixingsolutions.employee.entity;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.List;

@Data
@Table(name = "authority")
@Entity
public class Authority implements GrantedAuthority {
    @Id
    private Integer id;

    private String authority;

    @ManyToMany
    @JoinTable(
            name = "authorities_employee",
            joinColumns = @JoinColumn(name = "authority_id"),
            inverseJoinColumns = @JoinColumn(name = "employee_id"))
    private List<Employee> employee;
}
