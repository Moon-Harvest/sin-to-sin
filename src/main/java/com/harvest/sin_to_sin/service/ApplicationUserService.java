package com.harvest.sin_to_sin.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.harvest.sin_to_sin.model.ApplicationUser;
import com.harvest.sin_to_sin.model.ApplicationUserDTO;
import com.harvest.sin_to_sin.model.ApplicationUserDetails;
import com.harvest.sin_to_sin.repository.ApplicationUserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ApplicationUserService implements UserDetailsService {

        private final ApplicationUserRepository applicationUserRepository;
        private final PasswordEncoder passwordEncoder;

        @Transactional
        public ApplicationUser registerUser(String email, String username, String rawPassword) {
                if (applicationUserRepository.existsByEmail(email)) {
                        throw new ResponseStatusException(HttpStatus.CONFLICT,
                                        "User already exists with email: " + email);
                }

                ApplicationUser user = ApplicationUser.builder()
                                .email(email)
                                .username(username)
                                .hashedPassword(passwordEncoder.encode(rawPassword))
                                .role("USER")
                                .build();

                return applicationUserRepository
                                .save(user);
        }

        public List<ApplicationUserDTO> getAllUsers() {
                return applicationUserRepository.findAll().stream()
                                .map(user -> new ApplicationUserDTO(user.getEmail(), user.getUsername()))
                                .collect(Collectors.toList());
        }

        @Transactional(readOnly = true)
        public ApplicationUserDTO getUserByEmail(String email) {
                return applicationUserRepository.findByEmail(email)
                                .map(user -> new ApplicationUserDTO(user.getEmail(), user.getUsername()))
                                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                                                String.format("No user found with email %s", email)));
        }

        @Override
        public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
                return applicationUserRepository.findByEmail(email).map(ApplicationUserDetails::new)
                                .orElseThrow(() -> new UsernameNotFoundException(
                                                "User not found with email: " + email));
        }

}
