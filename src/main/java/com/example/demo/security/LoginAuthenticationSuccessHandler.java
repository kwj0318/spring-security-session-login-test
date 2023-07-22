package com.example.demo.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import java.io.IOException;

public class LoginAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        HttpSession session = request.getSession();
        UserDetails user = (UserDetails) authentication.getPrincipal();
        String url = getTargetUrl(user, session);
        session.setMaxInactiveInterval(60);
        response.sendRedirect(url);
    }

    private String getTargetUrl(UserDetails user, HttpSession session) {
        session.setAttribute("id", user.getUsername());
        if (user.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"))) {
            session.setAttribute("memberType", "ADMIN");
            return "/admin/members";
        }
        session.setAttribute("memberType", "USER");
        return "/members";
    }
}
