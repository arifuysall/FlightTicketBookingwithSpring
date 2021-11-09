package com.kodluyoruz.flightticketbooking.model.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "airports")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Airport extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false,unique = true,length = 50)
    private String name;

    @Column(nullable = false)
    private Integer gateCapacity;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "airport")
    private List<Gate> gates;


}
