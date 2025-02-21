package com.harvest.sin_to_sin.model;

import java.util.List;
import java.util.stream.Collectors;

import lombok.Data;

@Data
public class Catalog {

    private List<Product> products;

    public List<Product> getProductsOnSale() {
        return products.stream().filter(Product::isOnSale).collect(Collectors.toList());
    }

}
