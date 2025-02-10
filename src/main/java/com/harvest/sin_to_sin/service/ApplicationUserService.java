package com.harvest.sin_to_sin.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.harvest.sin_to_sin.exception.UserAlreadyExistsException;
import com.harvest.sin_to_sin.model.ApplicationUser;
import com.harvest.sin_to_sin.model.ApplicationUserDetails;
import com.harvest.sin_to_sin.repository.ApplicationUserRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ApplicationUserService implements UserDetailsService {

    private final ApplicationUserRepository applicationUserRepository;

    public ApplicationUser createUser(ApplicationUser user) throws UserAlreadyExistsException {
        if (applicationUserRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new UserAlreadyExistsException("User already exists with email: " + user.getEmail());
        }
        return applicationUserRepository.save(user);
    }

    public boolean userExists(String username) {
        return applicationUserRepository.existsByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        ApplicationUser user = applicationUserRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return new ApplicationUserDetails(user);
    }

}
