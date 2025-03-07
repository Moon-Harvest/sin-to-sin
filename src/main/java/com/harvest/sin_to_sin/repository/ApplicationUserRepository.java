package com.harvest.sin_to_sin.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.harvest.sin_to_sin.model.ApplicationUser;
import com.harvest.sin_to_sin.model.enums.Role;

@Repository
public interface ApplicationUserRepository extends JpaRepository<ApplicationUser, Long> {
    Optional<ApplicationUser> findByEmail(String email);

    Optional<ApplicationUser> findByIdAndRole(Long id, Role role);

    boolean existsByEmail(String email);
}
