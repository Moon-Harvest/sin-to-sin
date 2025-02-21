package com.harvest.sin_to_sin.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.harvest.sin_to_sin.model.ApplicationUser;

@Repository
public interface ApplicationUserRepository extends JpaRepository<ApplicationUser, Long>{
    Optional<ApplicationUser> findByEmail(String email);
    boolean existsByEmail(String email);
}
