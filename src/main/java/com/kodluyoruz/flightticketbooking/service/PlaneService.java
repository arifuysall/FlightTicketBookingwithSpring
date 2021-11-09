package com.kodluyoruz.flightticketbooking.service;

import com.kodluyoruz.flightticketbooking.exception.NotFoundException;
import com.kodluyoruz.flightticketbooking.model.dto.PlaneDto;
import com.kodluyoruz.flightticketbooking.model.entity.Plane;
import com.kodluyoruz.flightticketbooking.model.request.CreateUpdatePlaneRequest;
import com.kodluyoruz.flightticketbooking.repository.PlaneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.kodluyoruz.flightticketbooking.mapper.PlaneMapper.PLANE_MAPPER;

@Service
@RequiredArgsConstructor
public class PlaneService {
    private final PlaneRepository repository;

    public PlaneDto createPlane(CreateUpdatePlaneRequest request) {
        Plane plane = PLANE_MAPPER.createPlane(request);
        Plane savedPlane = repository.save(plane);
        return PLANE_MAPPER.toPlaneDto(savedPlane);
    }

    public Plane getPlaneEntity(int id){
        return repository.findById(id).orElseThrow(()-> new NotFoundException("Plane does not exists!"));
    }

    public PlaneDto getPlane(int id) {
        Plane plane = getPlaneEntity(id);
        return PLANE_MAPPER.toPlaneDto(plane);
    }

    public List<PlaneDto> getPlanes() {
        return PLANE_MAPPER.toPlaneDtoList(repository.findAll());
    }

    public PlaneDto updatePlane(int id, CreateUpdatePlaneRequest request) {
        Plane plane = getPlaneEntity(id);
        PLANE_MAPPER.updatePlane(plane,request);
        Plane updatedPlane = repository.save(plane);
        return PLANE_MAPPER.toPlaneDto(updatedPlane);
    }

    public void deletePlane(int id) {
        repository.deleteById(id);
    }
    protected void updateTakenSeatCount(int id, int count){
        repository.increaseTakenSeatCount(id,count);
    }
}
