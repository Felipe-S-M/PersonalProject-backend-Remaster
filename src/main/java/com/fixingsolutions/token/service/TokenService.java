package com.fixingsolutions.token.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fixingsolutions.employee.entity.Employee;
import com.fixingsolutions.employee.service.EmployeeService;
import com.fixingsolutions.token.utils.TokenUtils;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

@AllArgsConstructor
@Service
public class TokenService {
    private EmployeeService employeeService;

    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String authHeader = request.getHeader(AUTHORIZATION);
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            String refreshToken = authHeader.substring("Bearer ".length());
            Employee user = getUserFromToken(refreshToken);
            Map<String, String> tokens = new HashMap<>();
            tokens.put("refresh_token", refreshToken);
            tokens.put("access_token",
                    TokenUtils.createAccessToken(
                            user.getUsername(), user.getAuthorities(), request.getRequestURL().toString()
                    )
            );
            response.setContentType(MediaType.APPLICATION_JSON_VALUE);
            new ObjectMapper().writeValue(response.getOutputStream(), tokens);
        } else {
            throw new RuntimeException("Missing refresh token");
        }
    }

    public Employee getUserFromToken(String token) {
        JWTVerifier verifier = JWT.require(TokenUtils.getAlgorithm()).build();
        DecodedJWT decodedJWT = verifier.verify(token);
        String username = decodedJWT.getSubject();
        return employeeService.findByUsername(username);
    }
}
