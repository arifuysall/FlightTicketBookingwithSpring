package com.kodluyoruz.flightticketbooking.model.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AirportDto {
    private int id;
    private String name;
    private int gateCapacity;

}
