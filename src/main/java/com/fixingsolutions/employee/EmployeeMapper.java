package com.fixingsolutions.employee;

import com.fixingsolutions.authority.entity.Authority;
import com.fixingsolutions.employee.entity.Employee;

import java.util.List;

public class EmployeeMapper {
    public static Employee buildEmployee(String name, String username, String password, List<Authority> roles) {
        return Employee.builder()
                .name(name)
                .username(username)
                .password(password)
                .authorities(roles)
                .build();
    }
}
