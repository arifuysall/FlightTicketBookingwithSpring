package com.kodluyoruz.flightticketbooking.mapper;

import com.kodluyoruz.flightticketbooking.model.dto.FlightExpeditionDto;
import com.kodluyoruz.flightticketbooking.model.entity.FlightExpedition;
import com.kodluyoruz.flightticketbooking.model.request.CreateUpdateFlightExpeditionRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FlightExpeditionMapper {
    FlightExpeditionMapper FLIGHT_EXPEDITION_MAPPER = Mappers.getMapper(FlightExpeditionMapper.class);

    FlightExpedition createFlightExpedition(CreateUpdateFlightExpeditionRequest request);

    FlightExpeditionDto toFlightExpeditionDto( FlightExpedition flightExpedition);

    List<FlightExpeditionDto> toFlightExpeditionDtoList(List<FlightExpedition> flightExpeditions);

    void updateFlightExpeditions(@MappingTarget FlightExpedition flightExpedition, CreateUpdateFlightExpeditionRequest request);
}
