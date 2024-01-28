package com.example.springbootsecurityjwt.controller;

import com.example.springbootsecurityjwt.model.LoginRequest;
import com.example.springbootsecurityjwt.model.LoginResponse;
import com.example.springbootsecurityjwt.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/auth/login")
    public LoginResponse login(@RequestBody LoginRequest request) {
        return authService.attemptLogin(request.getEmail(), request.getPassword());
    }
}
