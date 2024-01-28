package com.vafaill.flightboot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vafaill.flightboot.dto.flight.FlightDTO;
import com.vafaill.flightboot.mapper.FlightMapper;
import com.vafaill.flightboot.model.Status;
import com.vafaill.flightboot.model.concrete.Flight;
import com.vafaill.flightboot.repo.FlightRepo;

import io.micrometer.common.lang.NonNull;

@Service
public class FlightService {

    @Autowired
    private FlightRepo _flightRepo;

    @Autowired
    private FlightMapper _flightMapper;

    // GET -----------------------------------------------------
    public List<FlightDTO> getAllFlights() {
        List<FlightDTO> flightDTOs = new ArrayList<>();

        Iterable<Flight> flightDAOs = _flightRepo.findAll();

        for (Flight flightDAO : flightDAOs) {
            flightDTOs.add(_flightMapper.toFlightDTO(flightDAO));
        }

        return flightDTOs;
    }

    public FlightDTO getFlightById(@NonNull long id) {
        Flight flightDAO = _flightRepo.findById(id).get();

        return _flightMapper.toFlightDTO(flightDAO);
    }

    public List<FlightDTO> getFlightsByDepartureCityName(@NonNull String departureCityName) {
        List<FlightDTO> flightDTOs = new ArrayList<>();

        Iterable<Flight> flightDAOs = _flightRepo.findAll();

        for (Flight flightDAO : flightDAOs) {
            if (flightDAO.getDepartureAirport().getCity().equals(departureCityName)) {
                flightDTOs.add(_flightMapper.toFlightDTO(flightDAO));
            }
        }

        return flightDTOs;
    }

    public List<FlightDTO> getFlightsMatchedBy(@NonNull FlightDTO flightDTO) {
        List<FlightDTO> flightDTOs = new ArrayList<>();

        Iterable<Flight> flightDAOs = _flightRepo.findAll();

        for (Flight flightDAO : flightDAOs) {
            if (flightDAO.getDepartureAirport().getCity().equals(flightDTO.getDepartureCityName()) &&
                    flightDAO.getArrivalAirport().getCity().equals(flightDTO.getArrivalCityName()) &&
                    flightDAO.getDepartureDateTime().equals(flightDTO.getDepartureDateTime()) &&
                    flightDAO.getReturnDateTime().equals(flightDTO.getReturnDateTime())) {
                flightDTOs.add(_flightMapper.toFlightDTO(flightDAO));
            }
        }

        return flightDTOs;
    }

    // POST ----------------------------------------------------
    public void addFlight(@NonNull FlightDTO flightDTO) {
        Flight flightDAO = _flightMapper.toFlightDAO(flightDTO);

        _flightRepo.save(flightDAO);
    }

    // DELETE --------------------------------------------------
    public void deleteFlight(@NonNull FlightDTO flightDTO) {
        Flight flightDAO = _flightMapper.toFlightDAO(flightDTO);

        flightDAO.setStatus(Status.INACTIVE);

        _flightRepo.delete(flightDAO);
    }

    public void deleteFlightById(@NonNull long id) {
        Flight flightDAO = _flightRepo.findById(id).get();

        flightDAO.setStatus(Status.INACTIVE);

        _flightRepo.deleteById(id);
    }

    public void deleteAllFlights() {
        Iterable<Flight> flightDAOs = _flightRepo.findAll();

        for (Flight flightDAO : flightDAOs) {
            flightDAO.setStatus(Status.INACTIVE);
        }

        _flightRepo.deleteAll();
    }

    // PUT -----------------------------------------------------
    public void updateFlight(@NonNull FlightDTO flightDTO) {
        Flight flightDAO = _flightMapper.toFlightDAO(flightDTO);

        _flightRepo.save(flightDAO);
    }

    public boolean flightExists(@NonNull FlightDTO flightDTO) {
        Flight flightDAO = _flightMapper.toFlightDAO(flightDTO);

        return _flightRepo.existsById(flightDAO.getId());
    }

    public boolean flightExistsById(@NonNull long id) {
        return _flightRepo.existsById(id);
    }

    public long countFlights() {
        return _flightRepo.count();
    }

    // Other ---------------------------------------------------
    public void fetchFlightDataFromThirdPartyAPI() {
        System.out.println("Fetching flight data from third party API...");
    }
}
