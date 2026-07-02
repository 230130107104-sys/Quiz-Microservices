package com.telusko.quiz_service.controller;

import com.telusko.quiz_service.model.LoginRequest;
import com.telusko.quiz_service.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private JwtService jwtService;

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {

        if ("admin".equals(request.getUsername())
                && "admin123".equals(request.getPassword())) {

            return jwtService.generateToken(request.getUsername());
        }

        return "Invalid Credentials";
    }
}