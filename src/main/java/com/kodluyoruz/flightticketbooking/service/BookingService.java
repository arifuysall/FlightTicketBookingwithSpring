package com.kodluyoruz.flightticketbooking.service;

import com.kodluyoruz.flightticketbooking.exception.BusinnesException;
import com.kodluyoruz.flightticketbooking.model.dto.BookingDto;
import com.kodluyoruz.flightticketbooking.model.dto.FlightExpeditionDto;
import com.kodluyoruz.flightticketbooking.model.dto.PlaneDto;
import com.kodluyoruz.flightticketbooking.model.entity.Booking;

import com.kodluyoruz.flightticketbooking.model.request.CreateUpdateBookingRequest;
import com.kodluyoruz.flightticketbooking.repository.BookingRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import static com.kodluyoruz.flightticketbooking.mapper.BookingMapper.BOOKING_MAPPER;

@Service
@RequiredArgsConstructor

public class BookingService {
    private final BookingRepository repository;
    private final PlaneService service;
    private final FlightExpeditionService flightExpeditionService;

    @Transactional(propagation = Propagation.REQUIRES_NEW)

    public BookingDto createBooking(CreateUpdateBookingRequest request) {
        Booking booking = BOOKING_MAPPER.createBooking(request);
        Booking savedBooking = repository.save(booking);
        FlightExpeditionDto flightExpeditionDto = flightExpeditionService.getFlightExpedition(request.getFlightExpeditionId());
        PlaneDto planeDto = service.getPlane(flightExpeditionDto.getPlaneId());
        service.updateTakenSeatCount(flightExpeditionDto.getPlaneId(),request.getTicketQuantity());

        if ( planeDto.getSeatCapacity() < planeDto.getTakenSeatCount() + request.getTicketQuantity()){
            throw new BusinnesException("There is no seats available!");
        }
        else{
            return BOOKING_MAPPER.toBookingDto(savedBooking);
        }
    }
}
