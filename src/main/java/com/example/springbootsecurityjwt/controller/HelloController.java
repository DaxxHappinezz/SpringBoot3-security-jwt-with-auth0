package com.example.springbootsecurityjwt.controller;

import com.example.springbootsecurityjwt.security.UserPrincipal;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String greeting() {
        return "Hello, security World!!!";
    }

    @GetMapping("/secured")
    public String secured(@AuthenticationPrincipal UserPrincipal principal) {
        return "if you see, then you're logged in as User: " + principal.getEmail() + ", User ID: " + principal.getUserId();
    }

    @GetMapping("/admin")
    public String admin(@AuthenticationPrincipal UserPrincipal principal) {
        return "if you see, then you are ADMIN. user ID: "+principal.getUserId();
    }
}
