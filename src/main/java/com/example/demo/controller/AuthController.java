package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    UserService userService;

    // POST /auth/register
    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userService.register(user);
    }

    // POST /auth/login
    @PostMapping("/login")
    public String login(@RequestBody User user) {
        return userService.login(user.getEmail(), user.getPassword());
    }
}
