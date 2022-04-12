package com.fixingsolutions.jwt.dto.response;

import lombok.Builder;

import java.io.Serializable;

@Builder
public class JwtResponse implements Serializable {
    private static final long serialVersionUID = -8091879091924046844L;
    private final String token;
}
