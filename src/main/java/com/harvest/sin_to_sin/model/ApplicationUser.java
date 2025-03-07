package com.harvest.sin_to_sin.model;

import com.harvest.sin_to_sin.model.enums.Role;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents a user in the system.
 * Users are identified by their unique email addresses.
 */
@Data
@Entity
@Table(name = "application_users", uniqueConstraints = {
        @UniqueConstraint(columnNames = "email")
})
@NoArgsConstructor
public class ApplicationUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true) 
    private String email;

    @Column(nullable = false) 
    private String username;

    @Column(nullable = false) 
    private String hashedPassword;

    @Enumerated(EnumType.STRING) 
    @Column(nullable = false)
    private Role role;

    /**
     * Constructs a new ApplicationUser with the given attributes.
     * 
     * @param id             The user's ID (null for new users, auto-generated).
     * @param email          The user's unique email.
     * @param username       The user's username (not necessarily unique).
     * @param hashedPassword The hashed password for authentication.
     * @param role           The user's role in the system.
     */
    @Builder 
    public ApplicationUser(Long id, String email, String username, String hashedPassword, Role role) {
        this.id = id;
        this.email = email;
        this.username = username;
        this.hashedPassword = hashedPassword;
        this.role = role;
    }
}
