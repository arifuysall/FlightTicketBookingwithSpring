package com.kodluyoruz.flightticketbooking.repository;

import com.kodluyoruz.flightticketbooking.model.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking,Integer> {
}
