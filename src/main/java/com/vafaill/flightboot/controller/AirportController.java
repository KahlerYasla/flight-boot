package com.vafaill.flightboot.controller;

import org.springframework.web.bind.annotation.RestController;

import com.vafaill.flightboot.dto.airport.AirportDTO;
import com.vafaill.flightboot.dto.airport.req.AirportNameUpdateDTO;
import com.vafaill.flightboot.service.AirportService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/airport")
public class AirportController {

    @Autowired
    private AirportService _airportService;

    @GetMapping("/")
    public Iterable<AirportDTO> getAllAirports() {
        return _airportService.getAllAirports();
    }

    @PostMapping("/add")
    public void addAirport(@RequestBody AirportDTO airportDTO) {
        _airportService.addAirport(airportDTO.getCity());
    }

    @PostMapping("/delete")
    public void deleteAirport(@RequestBody AirportDTO airportDTO) {
        _airportService.deleteAirport(airportDTO.getCity());
    }

    @PostMapping("/delete/{id}")
    public void deleteAirportById(@PathVariable long id) {
        _airportService.deleteAirportById(id);
    }

    @PostMapping("/update")
    public void updateAirport(@RequestBody AirportNameUpdateDTO airportNameDTO) {
        _airportService.updateAirport(airportNameDTO.getOldCity(), airportNameDTO.getNewCity());
    }

}
