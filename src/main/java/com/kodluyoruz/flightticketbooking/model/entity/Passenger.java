package com.kodluyoruz.flightticketbooking.model.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "passengers")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Passenger extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 20,nullable = false)
    private String name;

    @Column(length = 20,nullable = false)
    private String surname;

    @Column(length = 20,nullable = false,unique = true)
    private String socialSecurityNumber;

    @Column(length = 20,nullable = false,unique = true)
    private String email;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "passenger")
    private List<Booking> booking;

}
