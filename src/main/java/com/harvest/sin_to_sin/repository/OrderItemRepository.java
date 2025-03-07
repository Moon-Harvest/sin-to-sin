package com.harvest.sin_to_sin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.harvest.sin_to_sin.model.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
