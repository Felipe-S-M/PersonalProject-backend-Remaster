package com.fixingsolutions.authority.service;

import com.fixingsolutions.authority.AuthorityMapper;
import com.fixingsolutions.authority.entity.Authority;
import com.fixingsolutions.authority.repository.AuthorityRepository;
import lombok.AllArgsConstructor;
import lombok.var;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class AuthorityService {

    private AuthorityRepository authorityRepository;

    public Authority createAuthority(String role) {
        var authority = authorityRepository.findByRole(role);
        if (!authorityRepository.findByRole(role).isPresent()) {
            return authorityRepository.save(AuthorityMapper.buildAuthority(role));
        }
        return authority.get();
    }

}
