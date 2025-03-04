package com.harvest.sin_to_sin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.harvest.sin_to_sin.model.RegistrationForm;
import com.harvest.sin_to_sin.service.ApplicationUserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class RegistrationController {

    private final ApplicationUserService userService;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("registrationForm", new RegistrationForm());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(
            @ModelAttribute("registrationForm") RegistrationForm form,
            Model model) {
        try {
            userService.registerCustomer(form.getEmail(), form.getUsername(), form.getRawPassword());
            model.addAttribute("successMessage", "Registration successful! You can now log in.");
        } catch (Exception e) {
            model.addAttribute("errorMessage", "Registration failed: " + e.getMessage());
        }
        return "register";
    }

}
