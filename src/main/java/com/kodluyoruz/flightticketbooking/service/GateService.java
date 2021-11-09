package com.kodluyoruz.flightticketbooking.service;

import com.kodluyoruz.flightticketbooking.exception.BusinnesException;
import com.kodluyoruz.flightticketbooking.exception.NotFoundException;
import com.kodluyoruz.flightticketbooking.model.dto.GateDto;
import com.kodluyoruz.flightticketbooking.model.entity.Airport;
import com.kodluyoruz.flightticketbooking.model.entity.Gate;
import com.kodluyoruz.flightticketbooking.model.request.CreateUpdateGateRequest;
import com.kodluyoruz.flightticketbooking.repository.AirportRepository;
import com.kodluyoruz.flightticketbooking.repository.GateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.kodluyoruz.flightticketbooking.mapper.GateMapper.GATE_MAPPER;

@Service
@RequiredArgsConstructor
public class GateService {
    private final GateRepository repository;
    private final AirportRepository airportRepository;

    public GateDto createGate(CreateUpdateGateRequest request) {
        Airport airport = airportRepository.getById(request.getAirportId());
        if( airport.getGateCapacity() > airport.getGates().size()){
            Gate gate = GATE_MAPPER.createGate(request);
            Gate savedGate = repository.save(gate);
            return GATE_MAPPER.toGateDto(savedGate);
        }
        else{
           throw new BusinnesException("Airport has reached maximum gate capacity!");
        }

    }

    public Gate getGateEntity(int id){
        return repository.findById(id).orElseThrow(()-> new NotFoundException("Gate does not exists!"));
    }

    public List<GateDto> getGates() {
        return GATE_MAPPER.toGateDtoList(repository.findAll());
    }

    public GateDto getGate(int id) {
        Gate gate = getGateEntity(id);
        return GATE_MAPPER.toGateDto(gate);
    }

    public void deleteGate(int id) {
        repository.deleteById(id);
    }
}
