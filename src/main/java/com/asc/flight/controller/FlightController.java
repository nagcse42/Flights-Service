package com.asc.flight.controller;

import com.asc.flight.entity.FlightDetails;
import com.asc.flight.service.FlightService;
import com.asc.flight.vo.FlightDetailsVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/flight")
@Slf4j
public class FlightController {
    @Autowired
    FlightService flightService;

    @PostMapping("/save")
    public FlightDetails saveFlightDetails(@RequestBody FlightDetails flightDetails) {
        return flightService.saveFlightDetails(flightDetails);
    }

    @GetMapping("/find/{flightNumber}")
    public FlightDetailsVO findFlightByNumber(@PathVariable("flightNumber") Integer flightNumber) {
        return flightService.findFlightByNumber(flightNumber);
    }
}
