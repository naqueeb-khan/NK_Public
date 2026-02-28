package com.rts.utility;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class RequestInterceptor implements HandlerInterceptor {
@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String path = request.getRequestURI();

        // Block direct access to /user/**
        
        // if (path.startsWith("/user")) {
        //     response.sendError(HttpServletResponse.SC_FORBIDDEN, "Access denied. Go through BaseController.");
        //     return false; // stop request
        // }

        // Allow everything else
        return true;
    }
}
