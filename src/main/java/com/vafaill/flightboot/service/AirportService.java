package com.vafaill.flightboot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vafaill.flightboot.dao.concrete.AirportDAO;
import com.vafaill.flightboot.dto.airport.AirportDTO;
import com.vafaill.flightboot.mapper.AirportMapper;
import com.vafaill.flightboot.repo.AirportRepo;

@Service
public class AirportService {

    @Autowired
    private AirportMapper _airportMapper;

    @Autowired
    private AirportRepo _airportRepo;

    // GET -----------------------------------------------------
    public List<AirportDTO> getAllAirports() {
        List<AirportDTO> airportDTOs = new ArrayList<>();

        Iterable<AirportDAO> airportDAOs = _airportRepo.findAll();

        for (AirportDAO airportDAO : airportDAOs) {
            airportDTOs.add(_airportMapper.toAirportDTO(airportDAO));
        }

        return airportDTOs;
    }

    // POST -----------------------------------------------------
    public void addAirport(String airportName) {
        // New id
        long id = getAllAirports().size() + 1;

        AirportDAO airportDAO = new AirportDAO(id, airportName);

        _airportRepo.save(airportDAO);
    }

    // DELETE -----------------------------------------------------
    public void deleteAirport(String airportName) {
        Iterable<AirportDAO> airportDAOs = _airportRepo.findAll();

        for (AirportDAO airportDAO : airportDAOs) {
            if (airportDAO.getCity().equals(airportName)) {
                _airportRepo.delete(airportDAO);
            }
        }
    }

    public void deleteAirportById(long id) {
        _airportRepo.deleteById(id);
    }

    // PUT -----------------------------------------------------
    public void updateAirport(String oldAirportCity, String newAirportCity) {
        Iterable<AirportDAO> airportDAOs = _airportRepo.findAll();

        for (AirportDAO airportDAO : airportDAOs) {
            if (airportDAO.getCity().equals(oldAirportCity)) {
                airportDAO.setCity(newAirportCity);
                _airportRepo.save(airportDAO);
            }
        }
    }
}
