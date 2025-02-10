package com.harvest.sin_to_sin.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Catalog {

    private List<Product> products;

    public List<Product> getProductsOnSale() {
        List<Product> onSale = new ArrayList<>();
        for (Product product : products) {
            if (product.isOnSale()) {
                onSale.add(product);
            }
        }
        return onSale;
    }

}
