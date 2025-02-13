package com.harvest.sin_to_sin.model;

import java.util.Set;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class ApplicationUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String username;
    private String hashedPassword;
    @ElementCollection(fetch = FetchType.EAGER)
    private Set<String> roles;

    public ApplicationUser(String email, String username, String hashedPassword) {
        this.email = email;
        this.username = username;
        this.hashedPassword = hashedPassword;
    }
}
