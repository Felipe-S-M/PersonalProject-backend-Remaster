package com.fixingsolutions.userDetails.entity;

import com.fixingsolutions.employee.entity.Authority;
import com.fixingsolutions.employee.entity.Employee;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

@AllArgsConstructor
public class UserDetailsImpl implements UserDetails {
    private Employee employee;

    @Override
    public List<Authority> getAuthorities() {
        return employee.getAuthorities();
    }

    @Override
    public String getPassword() {
        return employee.getPassword();
    }

    @Override
    public String getUsername() {
        return employee.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
