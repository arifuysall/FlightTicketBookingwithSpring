package com.kodluyoruz.flightticketbooking.mapper;

import com.kodluyoruz.flightticketbooking.model.dto.PlaneDto;
import com.kodluyoruz.flightticketbooking.model.entity.Plane;
import com.kodluyoruz.flightticketbooking.model.request.CreateUpdatePlaneRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PlaneMapper {

    PlaneMapper PLANE_MAPPER = Mappers.getMapper(PlaneMapper.class);

    Plane createPlane(CreateUpdatePlaneRequest request);

    PlaneDto toPlaneDto(Plane plane);

    void updatePlane(@MappingTarget Plane plane, CreateUpdatePlaneRequest request);

    List<PlaneDto> toPlaneDtoList(List<Plane> planes);

}
