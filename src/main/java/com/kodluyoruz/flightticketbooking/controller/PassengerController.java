package com.kodluyoruz.flightticketbooking.controller;


import com.kodluyoruz.flightticketbooking.model.dto.PassengerDto;
import com.kodluyoruz.flightticketbooking.model.request.CreateUpdatePassengerRequest;
import com.kodluyoruz.flightticketbooking.service.PassengerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("passengers")
public class PassengerController {
    private final PassengerService service;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PassengerDto createPassenger(@RequestBody CreateUpdatePassengerRequest request){
        return service.createPassenger(request);
    }
    @GetMapping("{id}")
    public PassengerDto getPassenger(@PathVariable int id){
        return service.getPassenger(id);
    }

    @PutMapping("{id}")
    public PassengerDto updatePassenger(@PathVariable int id, @RequestBody CreateUpdatePassengerRequest request){
        return service.updatePassenger(id,request);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePassenger(@PathVariable int id){
        service.deletePassenger(id);
    }
}
