package com.kodluyoruz.flightticketbooking.model.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "bookings")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Booking extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "flight_expedition_id",nullable = false,updatable = false,insertable = false)
    private FlightExpedition flightExpedition;

    @Column(name = "flight_expedition_id",nullable = false)
    private Integer flightExpeditionId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "passenger_id",nullable = false,insertable = false,updatable = false)
    private Passenger passenger;

    @Column(name = "passenger_id",nullable = false)
    private Integer passengerId;

    @Column(nullable = false)
    private Integer ticketQuantity;


}
