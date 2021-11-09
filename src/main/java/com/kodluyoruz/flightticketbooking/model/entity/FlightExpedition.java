package com.kodluyoruz.flightticketbooking.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "flight_expeditions")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FlightExpedition extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "plane_id",nullable = false,updatable = false, insertable = false)
    private Plane plane;

    @NotNull
    @Column(name = "plane_id",nullable = false)
    private Integer planeId;

    @Column(nullable = false)
    private LocalDateTime flightDate;

    @Column(nullable = false)
    private Double flightPrice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "departure_gate_id",nullable = false,updatable = false, insertable = false)
    private Gate departureGate;

    @Column(name = "departure_gate_id",nullable = false)
    @NotNull
    private Integer departureGateId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "arrival_gate_id",nullable = false,updatable = false, insertable = false)
    private Gate arrivalGate;

    @NotNull
    @Column(name = "arrival_gate_id",nullable = false)
    private Integer arrivalGateId;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "flightExpedition")
    private List<Booking> booking;

}
