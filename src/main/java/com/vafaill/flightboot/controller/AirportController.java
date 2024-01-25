package com.vafaill.flightboot.controller;

import org.springframework.web.bind.annotation.RestController;

import com.vafaill.flightboot.dto.airport.AirportDTO;
import com.vafaill.flightboot.repo.AirportRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class AirportController {

    @Autowired
    private AirportRepo _airportRepo;

    @GetMapping("/airports")
    public Iterable<AirportDTO> getAirports() {
        var airpotResults = _airportRepo.findAll();

    }

}
