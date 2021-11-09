package com.kodluyoruz.flightticketbooking.service;

import com.kodluyoruz.flightticketbooking.exception.BusinnesException;
import com.kodluyoruz.flightticketbooking.exception.NotFoundException;
import com.kodluyoruz.flightticketbooking.model.dto.FlightExpeditionDto;
import com.kodluyoruz.flightticketbooking.model.entity.FlightExpedition;
import com.kodluyoruz.flightticketbooking.model.request.CreateUpdateFlightExpeditionRequest;
import com.kodluyoruz.flightticketbooking.repository.FlightExpeditionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.kodluyoruz.flightticketbooking.mapper.FlightExpeditionMapper.FLIGHT_EXPEDITION_MAPPER;

@Service
@RequiredArgsConstructor
public class FlightExpeditionService {
    private final FlightExpeditionRepository repository;

    public FlightExpeditionDto createFlightExpedition(CreateUpdateFlightExpeditionRequest request) {
        List<FlightExpedition> flightExpedition1 = repository.findAll();

        for (FlightExpedition expedition : flightExpedition1) {
            if (request.getDepartureGateId() == expedition.getDepartureGateId()) {
                if (request.getFlightDate().getDayOfWeek() == expedition.getFlightDate().getDayOfWeek()) {
                    if (request.getFlightDate().getHour() == expedition.getFlightDate().getHour()){
                        throw new BusinnesException("In that hour, there is a plane in this gate!");
                    }
                }
            }
        }
        if (request.getArrivalGateId() == request.getDepartureGateId()){
            throw new BusinnesException("Arrival and Departure Airports or Gates Can Not Be The Same");
        }


        else {
            FlightExpedition flightExpedition = FLIGHT_EXPEDITION_MAPPER.createFlightExpedition(request);
            FlightExpedition savedFlightExpedition = repository.save(flightExpedition);
            return FLIGHT_EXPEDITION_MAPPER.toFlightExpeditionDto(savedFlightExpedition);
        }

    }


    public List<FlightExpeditionDto> getAvailableFlightExpeditions() {
        List<FlightExpedition> flightExpedition = repository.findAll();
        List<FlightExpedition> availableFlights = new ArrayList<>();
        for( int i = 0; i<= flightExpedition.size(); i++){
            if(flightExpedition.get(i).getPlane().getSeatCapacity() > flightExpedition.get(i).getPlane().getTakenSeatCount()){
                availableFlights.add(flightExpedition.get(i));
                return FLIGHT_EXPEDITION_MAPPER.toFlightExpeditionDtoList(availableFlights);
            }
        }
        return null;

    }
    public FlightExpedition getFlightExpeditionEntity(int id){
        return repository.findById(id).orElseThrow(()->new NotFoundException("Flight does not exist!"));
    }

    public FlightExpeditionDto getFlightExpedition(int id) {
       FlightExpedition flightExpedition = getFlightExpeditionEntity(id);
       return FLIGHT_EXPEDITION_MAPPER.toFlightExpeditionDto(flightExpedition);
    }

    public List<FlightExpeditionDto> getAllFlightExpeditions() {
        List<FlightExpedition> flightExpeditions = repository.findAll();
        return FLIGHT_EXPEDITION_MAPPER.toFlightExpeditionDtoList(flightExpeditions);
    }
}
