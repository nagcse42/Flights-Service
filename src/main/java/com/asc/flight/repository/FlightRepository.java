package com.asc.flight.repository;

import com.asc.flight.entity.FlightDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends JpaRepository<FlightDetails, Integer> {
    FlightDetails findByNumber(Integer number);
}
