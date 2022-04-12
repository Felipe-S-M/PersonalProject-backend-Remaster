package com.fixingsolutions.jwt;

import com.fixingsolutions.jwt.dto.response.JwtResponse;

public class JwtMapper {
    public static JwtResponse buildResponse(String token) {
        return JwtResponse.builder()
                .token(token)
                .build();
    }
}
