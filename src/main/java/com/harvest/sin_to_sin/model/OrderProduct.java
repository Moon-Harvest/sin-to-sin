package com.harvest.sin_to_sin.model;

import java.util.List;

import jakarta.persistence.Id;
import lombok.Data;

@Data
public class OrderProduct {

    @Id
    private Long id;
    private Product product;
    private List<String> deliveryDetails;

}
