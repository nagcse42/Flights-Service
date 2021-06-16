package com.asc.flight.service;

import com.asc.flight.entity.FlightDetails;
import com.asc.flight.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlightService {
    @Autowired
    FlightRepository flightRepository;

    public FlightDetails saveFlightDetails(FlightDetails flightDetails) {
        return flightRepository.save(flightDetails);
    }

    public FlightDetails findFlightByNumber(Integer flightNumber) {
        return flightRepository.findByNumber(flightNumber);
    }
}
