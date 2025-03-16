package com.charan.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class JwtAuthFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        // Verify whether request has Authorization header and it has Bearer in it
       final String authHeader = request.getHeader("Authorization");
       String token;
       if(authHeader==null || !authHeader.startsWith("Bearer ")){
           filterChain.doFilter(request,response);
           return;
       }
       // Extract token from the Authorization
        token = authHeader.substring(7);
       // If user is present and no authentication object in SecurityContext
        if(SecurityContextHolder.getContext().getAuthentication() == null) {

        }

    }

    //Verify if it is a Whitelist URL and if yes don't do anything
    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        return request.getServletPath().contains("//user");
    }
}
