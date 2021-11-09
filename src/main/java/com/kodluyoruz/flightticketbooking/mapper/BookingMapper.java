package com.kodluyoruz.flightticketbooking.mapper;

import com.kodluyoruz.flightticketbooking.model.dto.BookingDto;
import com.kodluyoruz.flightticketbooking.model.entity.Booking;
import com.kodluyoruz.flightticketbooking.model.request.CreateUpdateBookingRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookingMapper {
    BookingMapper BOOKING_MAPPER = Mappers.getMapper(BookingMapper.class);

    Booking createBooking (CreateUpdateBookingRequest request);

    BookingDto toBookingDto(Booking booking);

    List<BookingDto> toBookingDtoList(List<Booking> bookings);

    void updateBooking(@MappingTarget Booking booking, CreateUpdateBookingRequest request);
}
