package com.kodluyoruz.flightticketbooking.mapper;

import com.kodluyoruz.flightticketbooking.model.dto.GateDto;
import com.kodluyoruz.flightticketbooking.model.entity.Gate;
import com.kodluyoruz.flightticketbooking.model.request.CreateUpdateGateRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GateMapper {
    GateMapper GATE_MAPPER = Mappers.getMapper(GateMapper.class);

    Gate createGate (CreateUpdateGateRequest request);

    GateDto toGateDto (Gate gate);

    List<GateDto> toGateDtoList (List<Gate> gates);
}
