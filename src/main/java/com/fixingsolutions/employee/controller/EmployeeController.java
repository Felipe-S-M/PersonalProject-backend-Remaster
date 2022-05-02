package com.fixingsolutions.employee.controller;

import com.fixingsolutions.employee.entity.Employee;
import com.fixingsolutions.employee.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/employee")
@Secured("ROLE_ADMIN")
public class EmployeeController {
    private EmployeeService employeeService;

    @GetMapping("/findAll")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }
}
