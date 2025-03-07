package com.harvest.sin_to_sin.model;

import java.util.List;
import java.util.stream.Collectors;

import lombok.Data;

/**
 * Represents the catalog of products available for customers.
 * Only products marked as "on sale" are visible in the catalog.
 */
@Data
public class Catalog {

    private List<Product> products;

    /**
     * Retrieves the list of products that are currently on sale.
     *
     * @return A list of products where {@code onSale} is {@code true}.
     */
    public List<Product> getProductsOnSale() {
        return products.stream()
                .filter(Product::isOnSale)
                .collect(Collectors.toList());
    }
}