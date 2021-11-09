package com.kodluyoruz.flightticketbooking.repository;

import com.kodluyoruz.flightticketbooking.model.entity.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportRepository extends JpaRepository<Airport,Integer> {
}
