package com.vafaill.flightboot.mapper;

import org.springframework.stereotype.Component;

import com.vafaill.flightboot.dao.concrete.AirportDAO;
import com.vafaill.flightboot.dto.airport.AirportDTO;

@Component
public class AirportMapper {

    // toDTO method
    public AirportDTO toAirportDTO(AirportDAO airportDAO) {
        AirportDTO airportDTO = new AirportDTO();

        airportDTO.setId(airportDAO.getId());
        airportDTO.setCity(airportDAO.getCity());

        return airportDTO;
    }
}
