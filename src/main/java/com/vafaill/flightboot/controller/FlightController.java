package com.vafaill.flightboot.controller;

import org.springframework.web.bind.annotation.RestController;

import com.vafaill.flightboot.dto.flight.FlightDTO;
import com.vafaill.flightboot.service.FlightService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("api/flight")
public class FlightController {

    @Autowired
    private FlightService _flightService;

    @GetMapping("/")
    public Iterable<FlightDTO> getAllFlights() {
        return _flightService.getAllFlights();
    }

    @GetMapping("/{id}")
    public FlightDTO getFlightById(@PathVariable long id) {
        return _flightService.getFlightById(id);
    }

    @GetMapping("/departure/{departureCityName}")
    public Iterable<FlightDTO> getFlightsByDepartureCityName(@PathVariable String departureCityName) {
        return _flightService.getFlightsByDepartureCityName(departureCityName);
    }

    @GetMapping("/match")
    public Iterable<FlightDTO> getFlightsMatchedBy(FlightDTO flightDTO) {
        boolean isOneWay = flightDTO.getDepartureCityName() == null || flightDTO.getDepartureCityName().isEmpty();

        return _flightService.getFlightsMatchedBy(flightDTO, isOneWay);
    }

    @PostMapping("/add")
    public void addFlight(@RequestBody FlightDTO flightDTO) {
        _flightService.addFlight(flightDTO);
    }

    @DeleteMapping("/delete")
    public void deleteFlight(@RequestBody FlightDTO flightDTO) {
        _flightService.deleteFlight(flightDTO);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteFlightById(@PathVariable long id) {
        _flightService.deleteFlightById(id);
    }

    @DeleteMapping("/delete/all")
    public void deleteAllFlights() {
        _flightService.deleteAllFlights();
    }

    @PutMapping("/update")
    public void updateFlight(@RequestBody FlightDTO flightDTO) {
        _flightService.updateFlight(flightDTO);
    }

    // Additional methods...

    @GetMapping("/exists")
    public boolean flightExists(@RequestBody FlightDTO flightDTO) {
        return _flightService.flightExists(flightDTO);
    }

    @GetMapping("/exists/{id}")
    public boolean flightExistsById(@PathVariable long id) {
        return _flightService.flightExistsById(id);
    }

    @GetMapping("/count")
    public long countFlights() {
        return _flightService.countFlights();
    }
}
