package com.kodluyoruz.flightticketbooking.repository;

import com.kodluyoruz.flightticketbooking.model.entity.Plane;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaneRepository extends JpaRepository<Plane,Integer> {
    @Query(value = "update #{#entityName} p set p.takenSeatCount=:count+p.takenSeatCount where p.id= :id")
    @Modifying(clearAutomatically = true)
    int increaseTakenSeatCount(@Param("id") Integer id, @Param("count") int count);


}
