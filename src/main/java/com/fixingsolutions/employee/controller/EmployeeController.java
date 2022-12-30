package com.fixingsolutions.employee.controller;

import com.fixingsolutions.employee.dto.request.CreateEmployeeRequest;
import com.fixingsolutions.employee.dto.request.UpdateEmployeeRequest;
import com.fixingsolutions.employee.dto.response.EmployeeResponse;
import com.fixingsolutions.employee.entity.Employee;
import com.fixingsolutions.employee.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @PostMapping("/createEmployee")
    public EmployeeResponse createEmployee(@Valid @RequestBody CreateEmployeeRequest request) {
        return employeeService.createEmployee(request);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id) {
        employeeService.deleteEmployee(id);
    }

    @PostMapping("/editEmployee")
    public EmployeeResponse updateEmployee(@Valid @RequestBody UpdateEmployeeRequest request) {
        return employeeService.updateEmployee(
                request.getId(),
                request.getName(),
                request.getUsername(),
                request.getPassword(),
                request.getAuthoritiesIds());
    }
}
