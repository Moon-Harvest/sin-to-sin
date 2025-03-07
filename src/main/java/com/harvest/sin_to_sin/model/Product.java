package com.harvest.sin_to_sin.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * Represents a product in the system.
 */
@Data
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id;

    @Column(nullable = false, length = 100) 
    private String name;

    @Column(length = 500) 
    private String description;

    @Column(nullable = false) 
    private float price;

    @Column(nullable = false) 
    private int stock;

    @Column(nullable = false) 
    private boolean onSale;
}
