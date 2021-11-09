package com.kodluyoruz.flightticketbooking.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GateDto {
    private int id;
    private String gateName;
    private int airportId;
}
