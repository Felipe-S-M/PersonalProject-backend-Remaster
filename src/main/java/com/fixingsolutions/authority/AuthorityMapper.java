package com.fixingsolutions.authority;

import com.fixingsolutions.authority.entity.Authority;

public class AuthorityMapper {
    public static Authority buildAuthority(String role) {
        return Authority.builder()
                .role(role)
                .build();
    }
}
