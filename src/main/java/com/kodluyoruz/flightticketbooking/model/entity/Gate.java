package com.kodluyoruz.flightticketbooking.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "gates")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Gate extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String gateName;

    @Builder.Default
    private Boolean isGateAvailable = true;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "airport_id",nullable = false,insertable = false,updatable = false)
    private Airport airport;

    @Column(name = "airport_id",nullable = false)
    private Integer airportId;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "arrivalGate")
    private List<FlightExpedition> flightExpeditionsArrivalGate;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "departureGate")
    private List<FlightExpedition> flightExpeditionsDepartureGate;
}
