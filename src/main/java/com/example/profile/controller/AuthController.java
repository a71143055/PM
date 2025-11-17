package com.example.profile.controller;

import com.example.profile.model.User;
import com.example.profile.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/auth")
public class AuthController {
    private final UserService userService;
    public AuthController(UserService userService) { this.userService = userService; }

    @GetMapping("/register")
    public String registerForm() { return "register"; }

    @PostMapping("/register")
    public String register(User user) {
        userService.save(user);
        return "redirect:/auth/login";
    }

    @GetMapping("/login")
    public String loginForm() { return "login"; }
}
