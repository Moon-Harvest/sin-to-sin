package com.harvest.sin_to_sin.model;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;

/**
 * Custom implementation of Spring Security's {@link UserDetails} interface.
 * Wraps an {@link ApplicationUser} entity to provide authentication details.
 */
@AllArgsConstructor // Generates a constructor with all arguments.
public class ApplicationUserDetails implements UserDetails {

    private final ApplicationUser user; // The wrapped application user.

    /**
     * Returns the authorities granted to the user.
     * Extracts the user's role and converts it into a
     * {@link SimpleGrantedAuthority}.
     *
     * @return A collection containing a single authority based on the user's role.
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority(user.getRole().getRoleName()));
    }

    /**
     * Returns the user's hashed password for authentication.
     *
     * @return The hashed password stored in the {@link ApplicationUser} entity.
     */
    @Override
    public String getPassword() {
        return user.getHashedPassword();
    }

    /**
     * Returns the username (email) of the user.
     * Spring Security uses this value for authentication.
     *
     * @return The email of the user.
     */
    @Override
    public String getUsername() {
        return user.getEmail();
    }

    /**
     * Indicates whether the user's account is non-expired.
     * This implementation always returns {@code true}, but can be modified as
     * needed.
     *
     * @return {@code true}, meaning the account is always considered non-expired.
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * Indicates whether the user's account is non-locked.
     * This implementation always returns {@code true}, but can be modified for
     * locking mechanisms.
     *
     * @return {@code true}, meaning the account is always considered non-locked.
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * Indicates whether the user's credentials (password) are non-expired.
     * This implementation always returns {@code true}, but can be modified for
     * password expiry policies.
     *
     * @return {@code true}, meaning credentials are always considered non-expired.
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * Indicates whether the user is enabled.
     * This implementation always returns {@code true}, but can be extended to
     * include activation logic.
     *
     * @return {@code true}, meaning the user is always considered enabled.
     */
    @Override
    public boolean isEnabled() {
        return true;
    }
}