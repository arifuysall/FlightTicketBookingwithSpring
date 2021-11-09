package com.kodluyoruz.flightticketbooking.controller;


import com.kodluyoruz.flightticketbooking.model.dto.GateDto;
import com.kodluyoruz.flightticketbooking.model.request.CreateUpdateGateRequest;
import com.kodluyoruz.flightticketbooking.service.GateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("gates")
public class GateController {
    private final GateService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public GateDto createGate(@RequestBody CreateUpdateGateRequest request){
        return service.createGate(request);
    }

    @GetMapping
    public List<GateDto> getGates(){
        return service.getGates();
    }
    @GetMapping("{id}")
    public GateDto getGate(@PathVariable int id){
        return service.getGate(id);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteGate(@PathVariable int id){
        service.deleteGate(id);
    }
}
