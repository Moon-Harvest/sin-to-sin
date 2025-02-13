package com.harvest.sin_to_sin.controller;

import org.springframework.web.bind.annotation.RestController;

import com.harvest.sin_to_sin.model.ApplicationUser;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@Controller
public class TestController {

    private final List<ApplicationUser> users = new ArrayList<>();

    @GetMapping("/")
    public String showHomePage(Model model) {
        model.addAttribute("users", users);
        return "index"; // Returns the Thymeleaf template
    }

    @PostMapping("/register")
    public String registerUser(@RequestParam String username,
                               @RequestParam String email,
                               @RequestParam String password,
                               Model model) {
        // Check if user already exists
        if (users.stream().anyMatch(u -> u.getEmail().equals(email))) {
            model.addAttribute("registerMessage", "User already exists!");
        } else {
            users.add(new ApplicationUser(username, email, password));
            model.addAttribute("registerMessage", "Registration successful!");
        }

        model.addAttribute("users", users); // Update user list
        return "index";
    }

    @PostMapping("/login")
    public String loginUser(@RequestParam String email,
                            @RequestParam String password,
                            Model model) {
        Optional<ApplicationUser> user = users.stream()
                .filter(u -> u.getEmail().equals(email) && u.getHashedPassword().equals(password))
                .findFirst();

        if (user.isPresent()) {
            model.addAttribute("loginMessage", "Login successful!");
        } else {
            model.addAttribute("loginMessage", "Invalid email or password!");
        }

        model.addAttribute("users", users);
        return "index";
    }

    @GetMapping("/users")
    public String listUsers(Model model) {
        model.addAttribute("users", users);
        return "index";
    }
}

