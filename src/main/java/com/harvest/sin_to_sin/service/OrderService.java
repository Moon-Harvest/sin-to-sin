package com.harvest.sin_to_sin.service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.harvest.sin_to_sin.model.ClientOrder;
import com.harvest.sin_to_sin.repository.OrderRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public Optional<ClientOrder> getOrderById(Long id) {
        return orderRepository.findById(id);
    }

    public Optional<List<ClientOrder>> getOrdersByDay(LocalDate date) {
        return orderRepository.findByOrderedAt(date);
    }

    public Optional<List<ClientOrder>> getOrdersByWeek(LocalDate date) {
        // Get the first day of the week (e.g., Monday)
        LocalDate startOfWeek = date.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
        LocalDate endOfWeek = startOfWeek.plusDays(6); // End of the week (Sunday)

        // Find orders by the week range
        return orderRepository.findByOrderedAtBetween(startOfWeek, endOfWeek);
    }

    public Optional<List<ClientOrder>> getOrdersByMonth(LocalDate date) {
        // Get the first day of the month
        LocalDate startOfMonth = date.with(TemporalAdjusters.firstDayOfMonth());
        LocalDate endOfMonth = startOfMonth.plusMonths(1).minusDays(1); // Last day of the month

        // Find orders by the month range
        return orderRepository.findByOrderedAtBetween(startOfMonth, endOfMonth);
    }

    public Optional<List<ClientOrder>> getOrdersByYear(LocalDate date) {
        // Get the first day of the year
        LocalDate startOfYear = date.with(TemporalAdjusters.firstDayOfYear());
        LocalDate endOfYear = startOfYear.plusYears(1).minusDays(1); // Last day of the year

        // Find orders by the year range
        return orderRepository.findByOrderedAtBetween(startOfYear, endOfYear);
    }

}
