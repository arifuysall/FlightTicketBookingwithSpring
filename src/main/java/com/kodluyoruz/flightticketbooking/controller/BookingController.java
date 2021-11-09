package com.kodluyoruz.flightticketbooking.controller;

import com.kodluyoruz.flightticketbooking.model.dto.BookingDto;
import com.kodluyoruz.flightticketbooking.model.request.CreateUpdateBookingRequest;
import com.kodluyoruz.flightticketbooking.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("bookings")
public class BookingController {
    private final BookingService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookingDto createBooking(@RequestBody CreateUpdateBookingRequest request){
        return service.createBooking(request);
    }

}
