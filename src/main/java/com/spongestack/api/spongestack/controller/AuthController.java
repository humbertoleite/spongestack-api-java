package com.spongestack.api.spongestack.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spongestack.api.spongestack.entity.AuthRequest;
import com.spongestack.api.spongestack.util.JwtUtil;

import java.util.List;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final JwtUtil jwtUtil;

    public AuthController(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public String login(@RequestBody AuthRequest authRequest) {
        System.out.println("Auth request: " + authRequest);
        if ("admin".equals(authRequest.getUsername()) && "password".equals(authRequest.getPassword())) {
            return jwtUtil.generateToken(authRequest.getUsername(), List.of("ADMIN"));
        } else if ("user".equals(authRequest.getUsername()) && "password".equals(authRequest.getPassword())) {
            return jwtUtil.generateToken(authRequest.getUsername(), List.of("USER"));
        }
        throw new RuntimeException("Invalid credentials");
    }
}