package com.kodluyoruz.flightticketbooking.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateUpdateFlightExpeditionRequest {

    private int planeId;
    private LocalDateTime flightDate;
    private double flightPrice;
    private int departureGateId;
    private int arrivalGateId;
}
    