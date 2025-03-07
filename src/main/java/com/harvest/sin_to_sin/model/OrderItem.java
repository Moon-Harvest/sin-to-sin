package com.harvest.sin_to_sin.model;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * Represents an item within a customer order.
 */
@Data
@Table(name = "order_items")
public class OrderItem {

    @Id
    private Long id;

    @Column(nullable = false) 
    private Long orderId;

    @Column(nullable = false) 
    private Long productId;

    @Column(nullable = false) 
    private int quantity;

    @Column(nullable = false) 
    private Float price;

    @Column(nullable = true) 
    private String deliveryDetails;
}