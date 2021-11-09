package com.kodluyoruz.flightticketbooking.mapper;

import com.kodluyoruz.flightticketbooking.model.dto.AirportDto;
import com.kodluyoruz.flightticketbooking.model.entity.Airport;
import com.kodluyoruz.flightticketbooking.model.request.CreateUpdateAirportRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AirportMapper {
    AirportMapper AIRPORT_MAPPER = Mappers.getMapper(AirportMapper.class);

    Airport createAirport(CreateUpdateAirportRequest request);

    AirportDto toAirportDto(Airport airport);

    void updateAirport(@MappingTarget Airport airport, CreateUpdateAirportRequest request);

    List<AirportDto> toAirportDtoList(List<Airport> airports);


}
