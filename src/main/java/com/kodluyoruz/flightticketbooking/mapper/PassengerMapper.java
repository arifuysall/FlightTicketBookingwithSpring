package com.kodluyoruz.flightticketbooking.mapper;


import com.kodluyoruz.flightticketbooking.model.dto.AirportDto;
import com.kodluyoruz.flightticketbooking.model.dto.PassengerDto;
import com.kodluyoruz.flightticketbooking.model.entity.Passenger;
import com.kodluyoruz.flightticketbooking.model.request.CreateUpdatePassengerRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PassengerMapper {

    PassengerMapper PASSENGER_MAPPER = Mappers.getMapper(PassengerMapper.class);

    Passenger createPassenger(CreateUpdatePassengerRequest request);

    PassengerDto toPassengerDto (Passenger passenger);

    void updatePassenger(@MappingTarget Passenger passenger, CreateUpdatePassengerRequest request);

    List<PassengerDto> toAirportDtoList(List<Passenger> passengers);
}
