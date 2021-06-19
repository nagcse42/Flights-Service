package com.asc.flight.service;

import com.asc.flight.entity.FlightDetails;
import com.asc.flight.repository.FlightRepository;
import com.asc.flight.vo.FlightDetailsVO;
import com.asc.flight.vo.Passenger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FlightService {
    @Autowired
    FlightRepository flightRepository;

    @Autowired
    RestTemplate restTemplate;

    public FlightDetails saveFlightDetails(FlightDetails flightDetails) {
        return flightRepository.save(flightDetails);
    }

    public FlightDetailsVO findFlightByNumber(Integer flightNumber) {
        FlightDetailsVO flightDetailsVO = new FlightDetailsVO();
        flightDetailsVO.setFlightDetails(flightRepository.findByNumber(flightNumber));
        flightDetailsVO.setPassengerList(getPassengerList(flightNumber));

        return flightDetailsVO;
    }

    private List<Passenger> getPassengerList(Integer flightNumber){
        List<Passenger> passengerList = restTemplate.getForObject("http://PASSENGER-SERVICE/passenger/flight/"+flightNumber, List.class);
        return passengerList;
    }
}
