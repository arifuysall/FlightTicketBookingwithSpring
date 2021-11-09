package com.kodluyoruz.flightticketbooking.repository;

import com.kodluyoruz.flightticketbooking.model.entity.Gate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GateRepository extends JpaRepository<Gate,Integer> {
}
