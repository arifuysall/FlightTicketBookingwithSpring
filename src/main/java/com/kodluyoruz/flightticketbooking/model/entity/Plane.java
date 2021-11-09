package com.kodluyoruz.flightticketbooking.model.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "planes")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Plane extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true,length = 6,nullable = false)
    private String flightCode;

    @Column(nullable = false)
    private Integer seatCapacity;

    private int takenSeatCount;

    @Builder.Default
    private Boolean isAvailable = true;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "plane")
    private List<FlightExpedition> flightExpeditions;


}
