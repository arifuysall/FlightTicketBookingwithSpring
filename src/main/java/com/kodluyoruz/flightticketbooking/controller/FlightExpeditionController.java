package com.kodluyoruz.flightticketbooking.controller;

import com.kodluyoruz.flightticketbooking.model.dto.FlightExpeditionDto;
import com.kodluyoruz.flightticketbooking.model.request.CreateUpdateFlightExpeditionRequest;
import com.kodluyoruz.flightticketbooking.service.FlightExpeditionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("flight_expeditions")
public class FlightExpeditionController {
    private final FlightExpeditionService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public FlightExpeditionDto createFlightExpedition(@RequestBody CreateUpdateFlightExpeditionRequest request){
        return service.createFlightExpedition(request);

    }
    @GetMapping("/available")
    public List<FlightExpeditionDto> getAvailableFlightExpeditions(){
        return service.getAvailableFlightExpeditions();
    }

    @GetMapping
    public List<FlightExpeditionDto> getAllFlightExpeditions(){
        return service.getAllFlightExpeditions();
    }

    @GetMapping("{id}")
    public FlightExpeditionDto getFlightExpedition(@PathVariable int id){
        return service.getFlightExpedition(id);
    }

}
