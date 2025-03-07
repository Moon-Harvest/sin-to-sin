package com.harvest.sin_to_sin.model;

import lombok.Builder;

/**
 * Data Transfer Object (DTO) for {@link ApplicationUser}.
 * Provides a lightweight representation of user data.
 *
 * @param id       The unique identifier of the user.
 * @param username The username of the user.
 * @param email    The email of the user.
 */
@Builder // Enables the builder pattern for easy object creation.
public record ApplicationUserDTO(Long id, String username, String email) {
}
