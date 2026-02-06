package com.svalero.sharewayapp.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Trip implements Serializable {
    private Long id;
    private String origin;
    private String destination;
    private LocalDateTime dateTime;
    private String transportTypes;
    private Integer availableSeats;
    private Integer price;
    private Boolean full;
}
