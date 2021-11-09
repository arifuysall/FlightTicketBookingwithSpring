package com.kodluyoruz.flightticketbooking.controller;

import com.kodluyoruz.flightticketbooking.model.dto.AirportDto;
import com.kodluyoruz.flightticketbooking.model.entity.Airport;
import com.kodluyoruz.flightticketbooking.model.request.CreateUpdateAirportRequest;
import com.kodluyoruz.flightticketbooking.service.AirportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("airports")
public class AirportController {
    private final AirportService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AirportDto createAirport(@RequestBody CreateUpdateAirportRequest request){
        return service.createAirport(request);
    }

    @GetMapping("{id}")
    public AirportDto getAirport(@PathVariable int id){
        return service.getAirport(id);
    }

    @GetMapping
    public List<AirportDto> getAirports(){
        return service.getAirports();
    }

    @PutMapping("{id}")
    public AirportDto updateAirport(@PathVariable int id, @RequestBody CreateUpdateAirportRequest request){
        return service.updateAirport(id,request);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAirport(@PathVariable int id){
        service.deleteAirport(id);
    }

}
