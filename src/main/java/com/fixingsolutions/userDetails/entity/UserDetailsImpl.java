package com.fixingsolutions.userDetails.entity;

import com.fixingsolutions.authority.entity.Authority;
import com.fixingsolutions.employee.entity.Employee;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

@Builder
@Data
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
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
