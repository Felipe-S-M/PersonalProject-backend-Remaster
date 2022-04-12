package com.fixingsolutions.userDetails.service;

import com.fixingsolutions.employee.repository.EmployeeRepository;
import com.fixingsolutions.userDetails.entity.UserDetailsImpl;
import lombok.AllArgsConstructor;
import lombok.var;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserDetailsServiceImpl implements org.springframework.security.core.userdetails.UserDetailsService {

    private EmployeeRepository employeeRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var employee = employeeRepository.findByUsername(username);
        return new UserDetailsImpl(employee.orElseThrow(() -> new UsernameNotFoundException("User not found")));
    }
}
