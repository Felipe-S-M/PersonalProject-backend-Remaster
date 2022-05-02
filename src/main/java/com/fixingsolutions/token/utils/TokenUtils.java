package com.fixingsolutions.token.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fixingsolutions.authority.entity.Authority;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class TokenUtils {
    public static String createAccessToken(String username, List<Authority> authorities, String url) {
        return JWT.create()
                .withSubject(username)
                .withExpiresAt(new Date(System.currentTimeMillis() + 10 * 60 * 1000))
                .withIssuer(url)
                .withClaim("roles", authorities.stream()
                        .map(Authority::getAuthority)
                        .collect(Collectors.toList()))
                .sign(getAlgorithm());
    }

    public static String createRefreshToken(String username, String url) {
        return JWT.create()
                .withSubject(username)
                .withExpiresAt(new Date(System.currentTimeMillis() + 10 * 60 * 1000))
                .withIssuer(url)
                .sign(getAlgorithm());
    }

    public static Algorithm getAlgorithm() {
        return Algorithm.HMAC256("secret".getBytes());
    }
}
