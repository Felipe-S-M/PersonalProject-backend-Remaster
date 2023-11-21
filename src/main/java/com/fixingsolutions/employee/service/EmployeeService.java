package com.fixingsolutions.employee.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fixingsolutions.authority.entity.Authority;
import com.fixingsolutions.authority.service.AuthorityService;
import com.fixingsolutions.employee.EmployeeMapper;
import com.fixingsolutions.employee.dto.request.CreateEmployeeRequest;
import com.fixingsolutions.employee.dto.response.EmployeeResponse;
import com.fixingsolutions.employee.entity.Employee;
import com.fixingsolutions.employee.repository.EmployeeRepository;
import com.fixingsolutions.token.utils.TokenUtils;
import com.fixingsolutions.utils.PasswordUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;
    private AuthorityService authorityService;

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public Employee findByUsername(String username) {
        return employeeRepository.findByUsername(username).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public void createDefaultAdminUser() {
        if (!employeeRepository.findByUsername("admin@fixingSolutions.com").isPresent()) {
            List<Authority> roles = new ArrayList<>();
            roles.add(authorityService.createAuthority("ROLE_ADMIN"));
            createEmployee("admin", "admin@fixingSolutions.com", "fixingSolutions", roles);
        }
    }

    public EmployeeResponse createEmployee(CreateEmployeeRequest request) {
        var roles = findAllRoles(request.getAuthoritiesIds());
        return createEmployee(request.getName(), request.getUsername(), request.getPassword(), roles);
    }

    public EmployeeResponse createEmployee(String name, String username, String password, List<Authority> roles) {
        var encodedPassword = PasswordUtils.encodePassword(password);
        var employee = EmployeeMapper.buildEmployee(name, username, encodedPassword, roles);
        return EmployeeMapper.buildEmployeeResponse(employeeRepository.save(employee));
    }

    public void deleteEmployee(Integer employeeId) {
        employeeRepository.delete(employeeRepository.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("User not found")));
    }

    public EmployeeResponse updateEmployee(
            Integer id, String name, String username, String password, List<Integer> rolesIds) {
        var employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
        var roles = findAllRoles(rolesIds);
        var encodedPassword = PasswordUtils.encodePassword(password);
        employee.setPassword(encodedPassword);
        employee.setName(name);
        employee.setUsername(username);
        employee.setAuthorities(roles);
        return EmployeeMapper.buildEmployeeResponse(employeeRepository.save(employee));
    }

    private List<Authority> findAllRoles(List<Integer> rolesIds) {
        List<Authority> roles = new ArrayList<>();
        for(Integer id : rolesIds) {
            roles.add(authorityService.findById(id));
        }
        return roles;
    }

    public Employee getEmployeeFromToken(String authToken) {
        String token = authToken.substring("Bearer ".length());
        JWTVerifier verifier = JWT.require(TokenUtils.getAlgorithm()).build();
        DecodedJWT decodedJWT = verifier.verify(token);
        return employeeRepository.findByUsername(decodedJWT.getSubject())
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

}
