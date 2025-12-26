package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.security.JwtUtil;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final JwtUtil jwtUtil;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public AuthController(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {

        // demo-only login
        if (!encoder.matches(user.getPassword(), encoder.encode(user.getPassword()))) {
            throw new RuntimeException("Invalid credentials");
        }

        return jwtUtil.generateToken(
                user.getUsername(),
                user.getRole(),
                user.getId(),
                user.getEmail()
        );
    }
}
