package com.fixingsolutions.userDetails.service;

import com.fixingsolutions.employee.entity.Employee;
import com.fixingsolutions.employee.repository.EmployeeRepository;
import com.fixingsolutions.userDetails.UserDetailsMapper;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private EmployeeRepository employeeRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Employee employee = employeeRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Employee not found"));
        return UserDetailsMapper.buildUserDetailsImpl(employee);
    }
}
