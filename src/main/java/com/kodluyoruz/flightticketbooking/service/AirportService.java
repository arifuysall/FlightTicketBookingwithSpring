package com.kodluyoruz.flightticketbooking.service;

import com.kodluyoruz.flightticketbooking.exception.NotFoundException;
import com.kodluyoruz.flightticketbooking.model.dto.AirportDto;
import com.kodluyoruz.flightticketbooking.model.entity.Airport;
import com.kodluyoruz.flightticketbooking.model.request.CreateUpdateAirportRequest;
import com.kodluyoruz.flightticketbooking.repository.AirportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.kodluyoruz.flightticketbooking.mapper.AirportMapper.AIRPORT_MAPPER;

@Service
@RequiredArgsConstructor
public class AirportService {
    private final AirportRepository airportRepository;

    public AirportDto createAirport(CreateUpdateAirportRequest request) {
        Airport airport = AIRPORT_MAPPER.createAirport(request);
        Airport savedAirport = airportRepository.save(airport);
        return AIRPORT_MAPPER.toAirportDto(savedAirport);
    }

    public Airport getAirportEntity(int id){
        return airportRepository.findById(id).orElseThrow(()-> new NotFoundException("Airport Not Found!"));
    }
    
    public AirportDto getAirport(int id) {
        Airport airport = getAirportEntity(id);
        return AIRPORT_MAPPER.toAirportDto(airport);
    }

    public AirportDto updateAirport(int id, CreateUpdateAirportRequest request) {
        Airport airport = getAirportEntity(id);
        AIRPORT_MAPPER.updateAirport(airport,request);
        Airport updatedAirport = airportRepository.save(airport);
        return AIRPORT_MAPPER.toAirportDto(updatedAirport);
    }

    public void deleteAirport(int id) {
        airportRepository.deleteById(id);
    }

    public List<AirportDto> getAirports() {
        return AIRPORT_MAPPER.toAirportDtoList(airportRepository.findAll());
    }
}
