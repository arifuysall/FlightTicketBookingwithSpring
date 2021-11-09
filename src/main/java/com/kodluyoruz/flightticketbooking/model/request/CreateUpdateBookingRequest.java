package com.kodluyoruz.flightticketbooking.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateUpdateBookingRequest {
    private int flightExpeditionId;
    private int passengerId;
    private int ticketQuantity;
}
