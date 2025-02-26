package com.harvest.sin_to_sin.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.harvest.sin_to_sin.model.CustomerOrder;

public interface OrderRepository extends JpaRepository<CustomerOrder, Long> {
    Optional<List<CustomerOrder>> findByOrderedAt(LocalDate date);

    Optional<List<CustomerOrder>> findByOrderedAtBetween(LocalDate startDate, LocalDate endDate);
}
