package com.harvest.sin_to_sin.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.harvest.sin_to_sin.model.ClientOrder;

public interface OrderRepository extends JpaRepository<ClientOrder, Long> {
    Optional<List<ClientOrder>> findByOrderedAt(LocalDate date);

    Optional<List<ClientOrder>> findByOrderedAtBetween(LocalDate startDate, LocalDate endDate);
}
