package com.kodluyoruz.flightticketbooking.service;

import com.kodluyoruz.flightticketbooking.exception.BusinnesException;
import com.kodluyoruz.flightticketbooking.model.dto.FlightExpeditionDto;
import com.kodluyoruz.flightticketbooking.model.dto.PlaneDto;
import com.kodluyoruz.flightticketbooking.model.request.CreateUpdateBookingRequest;
import com.kodluyoruz.flightticketbooking.repository.BookingRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BookingServiceTest {
    @InjectMocks
    private BookingService sut;
    @Mock
    private PlaneService service;
    @Mock
    private FlightExpeditionService flightExpeditionService;

    @ParameterizedTest
    @ValueSource(ints = {3,5,7})
    void it_should_throw_exception_plane_has_no_more_seats(int quantity) {

        //Given

        CreateUpdateBookingRequest request = CreateUpdateBookingRequest.builder()
                .flightExpeditionId(1)
                .passengerId(1)
                .ticketQuantity(quantity)
                .build();

        PlaneDto planeDto = PlaneDto.builder()
                .id(1)
                .flightCode("TK2121")
                .seatCapacity(5)
                .takenSeatCount(3)
                .build();

        FlightExpeditionDto flightExpeditionDto = FlightExpeditionDto.builder()
                .id(1)
                .arrivalGateId(1)
                .departureGateId(2)
                .flightDate(LocalDateTime.now())
                .planeId(1)
                .build();

            when(service.getPlane(anyInt())).thenReturn(planeDto);
            when(flightExpeditionService.getFlightExpedition(anyInt())).thenReturn(flightExpeditionDto);

        //When
        //Then

        Assertions.assertThrows(BusinnesException.class,()->sut.createBooking(request));
    }
}
