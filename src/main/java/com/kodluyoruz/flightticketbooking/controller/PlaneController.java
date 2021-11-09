package com.kodluyoruz.flightticketbooking.controller;


import com.kodluyoruz.flightticketbooking.model.dto.PlaneDto;
import com.kodluyoruz.flightticketbooking.model.request.CreateUpdatePlaneRequest;
import com.kodluyoruz.flightticketbooking.service.PlaneService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("planes")
public class PlaneController {
    private final PlaneService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PlaneDto createPlane(@RequestBody CreateUpdatePlaneRequest request){
        return service.createPlane(request);
    }

    @GetMapping("{id}")
    public PlaneDto getPlane(@PathVariable int id){
        return service.getPlane(id);
    }
    @GetMapping
    public List<PlaneDto> getPlanes(){
        return service.getPlanes();
    }

    @PutMapping("{id}")
    public PlaneDto updatePlane(@PathVariable int id, @RequestBody CreateUpdatePlaneRequest request){
        return service.updatePlane(id,request);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePlane(@PathVariable int id){
        service.deletePlane(id);
    }
}
