package com.harvest.sin_to_sin.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * Represents the registration form data provided by a user.
 */
@Data
public class RegistrationForm {

    @NotBlank 
    @Email 
    private String email;

    @NotBlank 
    private String username;

    @NotBlank 
    @Size(min = 6, message = "Password must be at least 6 characters long") 
    private String rawPassword;
}
