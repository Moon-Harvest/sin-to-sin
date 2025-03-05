package com.harvest.sin_to_sin.security;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.harvest.sin_to_sin.model.Role;

import java.io.IOException;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
            HttpServletResponse response,
            Authentication authentication) throws IOException, ServletException {

        Set<String> roles = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toSet());

        if (roles.contains(Role.ADMIN.getRoleName())) {
            System.out.println("REDIRECTING TO THE ADMIN DASHBOARD!");
            response.sendRedirect("/admin/dashboard");
        } else if (roles.contains(Role.CUSTOMER.getRoleName())) {
            System.out.println("REDIRECTING TO THE POORS DASHBOARD!");
            response.sendRedirect("/customer/dashboard");
        } else {
            System.out.println("WHAT IN THE ACTUAL HELL");
            response.sendRedirect("/default");
        }
    }
}
