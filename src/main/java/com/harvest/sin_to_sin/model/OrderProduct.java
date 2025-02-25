package com.harvest.sin_to_sin.model;

import jakarta.persistence.Id;
import lombok.Data;

@Data
public class OrderProduct {

    @Id
    private Long id;
    private Long orderId;
    private Product product;
    private String deliveryDetails;

}
