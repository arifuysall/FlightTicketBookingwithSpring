package com.kodluyoruz.flightticketbooking.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookingDto {
    private int id;
    private int flightExpeditionId;
    private int passengerId;
    private int ticketQuantity;
}
