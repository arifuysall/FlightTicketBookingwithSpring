package com.kodluyoruz.flightticketbooking.model.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PlaneDto {
    private int id;
    private String flightCode;
    private int seatCapacity;
    private int takenSeatCount;
}
