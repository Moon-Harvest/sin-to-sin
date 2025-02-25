package com.harvest.sin_to_sin.model;

import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class ClientOrder {

    @Id
    private Long id;
    private LocalDate orderedAt;
    private LocalDate orderWillBeReadyAt;

}
