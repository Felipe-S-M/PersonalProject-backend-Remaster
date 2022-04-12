package com.fixingsolutions.jwt;

import com.fixingsolutions.jwt.service.JwtTokenUtilService;
import com.fixingsolutions.jwt.service.JwtUserDetailsService;
import lombok.AllArgsConstructor;
import lombok.var;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@AllArgsConstructor
public class JwtRequestFilter extends OncePerRequestFilter {

    private JwtUserDetailsService jwtUserDetailsService;
    private JwtTokenUtilService jwtTokenUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {
        var username = getUsername(request.getHeader("Authorization"));
        if (username != null && !username.isEmpty() && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = this.jwtUserDetailsService.loadUserByUsername(username);
            if (jwtTokenUtil.validateToken(getJwtToken(request.getHeader("Authorization")), userDetails)) {
                setAuthenticationContext(userDetails, request);
            }
        }
        chain.doFilter(request, response);
    }

    private String getJwtToken(String authorization) {
        return authorization.substring(7);
    }

    private void setAuthenticationContext(UserDetails userDetails, HttpServletRequest request) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                userDetails, null, userDetails.getAuthorities());
        usernamePasswordAuthenticationToken
                .setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
    }

    private String getUsername(String token) {
        return token != null && token.startsWith("Bearer ") ? jwtTokenUtil.getUsernameFromToken(token) : "";
    }

}
