package com.vafaill.flightboot.mapper;

import org.springframework.stereotype.Component;

import com.vafaill.flightboot.dto.airport.AirportDTO;
import com.vafaill.flightboot.model.concrete.Airport;

@Component
public class AirportMapper {

    // toDTO method
    public AirportDTO toAirportDTO(Airport airportDAO) {
        AirportDTO airportDTO = new AirportDTO();

        airportDTO.setId(airportDAO.getId());
        airportDTO.setCity(airportDAO.getCity());

        return airportDTO;
    }
}
