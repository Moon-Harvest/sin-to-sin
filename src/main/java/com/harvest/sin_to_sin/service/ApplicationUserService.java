package com.harvest.sin_to_sin.service;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.harvest.sin_to_sin.model.ApplicationUser;
import com.harvest.sin_to_sin.model.ApplicationUserDetails;
import com.harvest.sin_to_sin.repository.ApplicationUserRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ApplicationUserService implements UserDetailsService {

    private final ApplicationUserRepository applicationUserRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public ApplicationUser createUser(String email, String username, String rawPassword) {
        if (applicationUserRepository.findByEmail(email).isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT,
                    "User already exists with email: " + email);
        }
        return applicationUserRepository
                .save(new ApplicationUser(email, username, passwordEncoder.encode(rawPassword)));
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        ApplicationUser user = applicationUserRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return new ApplicationUserDetails(user);
    }

}
