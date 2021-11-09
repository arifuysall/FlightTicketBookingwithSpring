package com.kodluyoruz.flightticketbooking.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PassengerDto {
    private int id;
    private String name;
    private String surname;
    private String socialSecurityNumber;
    private String email;
}
