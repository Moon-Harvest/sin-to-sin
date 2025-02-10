package com.harvest.sin_to_sin.model;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;

@Data
public class Order {

    private List<OrderProduct> orderedProducts;
    private LocalDateTime orderedAt;
    private LocalDateTime orderWillBeReadyAt;

}
