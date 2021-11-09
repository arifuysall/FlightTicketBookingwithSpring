package com.kodluyoruz.flightticketbooking.service;

import com.kodluyoruz.flightticketbooking.exception.NotFoundException;
import com.kodluyoruz.flightticketbooking.model.dto.PassengerDto;
import com.kodluyoruz.flightticketbooking.model.entity.Passenger;
import com.kodluyoruz.flightticketbooking.model.request.CreateUpdatePassengerRequest;
import com.kodluyoruz.flightticketbooking.repository.PassengerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.kodluyoruz.flightticketbooking.mapper.PassengerMapper.PASSENGER_MAPPER;

@Service
@RequiredArgsConstructor
public class PassengerService {
    private final PassengerRepository repository;

    public PassengerDto createPassenger(CreateUpdatePassengerRequest request) {
        Passenger passenger = PASSENGER_MAPPER.createPassenger(request);
        Passenger savedPassenger = repository.save(passenger);
        return PASSENGER_MAPPER.toPassengerDto(savedPassenger);

    }

    public Passenger getPassengerEntity(int id){
        return repository.findById(id).orElseThrow(()-> new NotFoundException("There is no Passenger!"));
    }


    public PassengerDto getPassenger(int id) {
        Passenger passenger = getPassengerEntity(id);
        return PASSENGER_MAPPER.toPassengerDto(passenger);
    }

    public PassengerDto updatePassenger(int id, CreateUpdatePassengerRequest request) {
        Passenger passenger = getPassengerEntity(id);
        PASSENGER_MAPPER.updatePassenger(passenger,request);
        Passenger updatedPassenger = repository.save(passenger);
        return PASSENGER_MAPPER.toPassengerDto(updatedPassenger);

    }

    public void deletePassenger(int id) {
        repository.deleteById(id);
    }
}
