package com.fixingsolutions.authority.service;

import com.fixingsolutions.authority.AuthorityMapper;
import com.fixingsolutions.authority.entity.Authority;
import com.fixingsolutions.authority.repository.AuthorityRepository;
import com.fixingsolutions.employee.entity.Employee;
import lombok.AllArgsConstructor;
import lombok.var;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class AuthorityService {

    private AuthorityRepository authorityRepository;

    public List<Authority> findAll() {
        return authorityRepository.findAll();
    }

    public Authority createAuthority(String role) {
        var authority = authorityRepository.findByRole(role);
        return authority.orElseGet(() -> authorityRepository.save(AuthorityMapper.buildAuthority(role)));
    }

    public Authority updateAuthority(String role, Integer id) {
        var authority = authorityRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Authority not found"));
        authority.setRole(role);
        return authorityRepository.save(authority);
    }

    public void delete(Integer id) {
        authorityRepository.delete(authorityRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Authority not found")));
    }

}
