package com.kodluyoruz.flightticketbooking.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;
import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FlightExpeditionDto {
    private int id;
    private int planeId;
    private LocalDateTime flightDate;
    private double flightPrice;
    private int departureGateId;
    private int arrivalGateId;
}
