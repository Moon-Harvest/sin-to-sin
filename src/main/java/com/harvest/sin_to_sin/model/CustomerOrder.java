package com.harvest.sin_to_sin.model;

import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class CustomerOrder {

    @Id
    private Long id;
    private LocalDate orderedAt;
    private LocalDate orderWillBeReadyAt;

}
