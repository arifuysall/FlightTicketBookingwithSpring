package com.kodluyoruz.flightticketbooking.repository;

import com.kodluyoruz.flightticketbooking.model.entity.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger,Integer> {
}
