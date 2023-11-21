package com.fixingsolutions.config.authenticationFilter;

import com.fixingsolutions.token.utils.TokenUtils;
import com.fixingsolutions.userDetails.entity.UserDetailsImpl;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@AllArgsConstructor
public class AuthenticationFilterImpl extends UsernamePasswordAuthenticationFilter {
    private AuthenticationManager authenticationManager;
    @Override
    public Authentication attemptAuthentication(
            HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);
        return authenticationManager.authenticate(token);
    }

    @Override
    protected void successfulAuthentication(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain chain,
            Authentication auth
    ) {
        UserDetailsImpl user = (UserDetailsImpl) auth.getPrincipal();
        var employee = user.getEmployee();
        response.setHeader("access_token",
                TokenUtils.createAccessToken(
                        employee.getUsername(), employee.getAuthorities(), request.getRequestURL().toString()));
        response.setHeader("refresh_token",
                TokenUtils.createRefreshToken(employee.getUsername(), request.getRequestURL().toString()));
    }
}
