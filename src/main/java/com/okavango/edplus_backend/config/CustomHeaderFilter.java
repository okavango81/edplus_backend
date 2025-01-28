package com.okavango.edplus_backend.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

//@Component
public class CustomHeaderFilter extends OncePerRequestFilter
    {
        private static final String SECRET_HEADER = "X-SECRET-KEY";
        private static final String SECRET_VALUE = "123456";

        @Override
        protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException
            {
                String headerValue = request.getHeader(SECRET_HEADER);
                if (!SECRET_VALUE.equals(headerValue)) {
                    response.sendError(HttpServletResponse.SC_FORBIDDEN, "Access denied");
                    return;
                }
                filterChain.doFilter(request, response);
            }
    }
