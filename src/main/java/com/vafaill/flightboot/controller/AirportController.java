package com.vafaill.flightboot.controller;

import org.springframework.web.bind.annotation.RestController;

import com.vafaill.flightboot.dto.airport.AirportDTO;
import com.vafaill.flightboot.repo.AirportRepo;
import com.vafaill.flightboot.service.AirportService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/airport")
public class AirportController {

    @Autowired
    private AirportService _airportService;

    // @GetMapping("/")
    // public Iterable<AirportDTO> getAllAirports() {
    // return _airportService.getAllAirports();
    // }

}
