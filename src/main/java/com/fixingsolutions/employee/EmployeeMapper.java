package com.fixingsolutions.employee;

import com.fixingsolutions.authority.entity.Authority;
import com.fixingsolutions.employee.dto.response.EmployeeResponse;
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

    public static EmployeeResponse buildEmployeeResponse(Employee employee) {
        return EmployeeResponse.builder()
                .id(employee.getId())
                .name(employee.getName())
                .username(employee.getUsername())
                .authorities(employee.getAuthorities())
                .build();
    }
}
