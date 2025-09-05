package com.example.leaderboardsystem.controller;

import com.example.leaderboardsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String index () {
        return "index";
    }

    @GetMapping("/register")
    public String showRegisterForm () {
        return "register";
    }

    @PostMapping("/register")
    public String registerUser (@RequestParam String username, @RequestParam String email, @RequestParam String password, Model model) {
        try {
            this.userService.register (username, email, password);
            return "redirect:/login";
        } catch (IllegalArgumentException e) {
            model.addAttribute ("error", e.getMessage ());
            return "register";
        }
    }

    @GetMapping("/login")
    public String showLoginForm () {
        return "login";
    }
}