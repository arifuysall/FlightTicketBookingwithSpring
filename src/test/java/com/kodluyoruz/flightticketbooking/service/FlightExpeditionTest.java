package com.kodluyoruz.flightticketbooking.service;


import com.kodluyoruz.flightticketbooking.exception.BusinnesException;
import com.kodluyoruz.flightticketbooking.model.entity.FlightExpedition;
import com.kodluyoruz.flightticketbooking.model.request.CreateUpdateFlightExpeditionRequest;
import com.kodluyoruz.flightticketbooking.repository.FlightExpeditionRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import java.util.ArrayList;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FlightExpeditionTest {
    @InjectMocks
    private FlightExpeditionService sut;
    @Mock
    private FlightExpeditionRepository repository;

    @Test
    void it_shout_throw_exception_same_time_same_gate() {

        CreateUpdateFlightExpeditionRequest request = CreateUpdateFlightExpeditionRequest.builder()
                .arrivalGateId(1)
                .departureGateId(2)
                .flightDate(LocalDateTime.now())
                .flightPrice(1)
                .planeId(2)
                .build();

        List<FlightExpedition> flightExpeditions = new ArrayList<>();
        FlightExpedition flightExpedition = FlightExpedition.builder()
                .arrivalGateId(3)
                .departureGateId(2)
                .flightDate(LocalDateTime.now())
                .planeId(3)
                .build();
        flightExpeditions.add(flightExpedition);

        when(repository.findAll()).thenReturn(flightExpeditions);
        Assertions.assertThrows(BusinnesException.class,()->sut.createFlightExpedition(request));
        Assertions.assertEquals(request.getDepartureGateId(),flightExpedition.getDepartureGateId());
        Assertions.assertEquals(request.getFlightDate().getDayOfWeek(),flightExpedition.getFlightDate().getDayOfWeek());
        Assertions.assertEquals(request.getFlightDate().getHour(),flightExpedition.getFlightDate().getHour());
    }
}
