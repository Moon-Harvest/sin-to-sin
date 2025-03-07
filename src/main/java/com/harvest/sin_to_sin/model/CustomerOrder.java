package com.harvest.sin_to_sin.model;

import java.time.LocalDateTime;

import com.harvest.sin_to_sin.model.enums.OrderStatus;
import com.harvest.sin_to_sin.model.enums.OrderType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * Represents a customer order in the system.
 */
@Data
@Entity
@Table(name = "customer_orders")
public class CustomerOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id;

    @Column(nullable = false) 
    private Long customerId;

    @Column(nullable = false) 
    private Float totalPrice;

    @Enumerated(EnumType.STRING) 
    @Column(nullable = false)
    private OrderStatus orderStatus;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private OrderType orderType;

    @Column(nullable = false, updatable = false) 
    private LocalDateTime orderDate;
}
