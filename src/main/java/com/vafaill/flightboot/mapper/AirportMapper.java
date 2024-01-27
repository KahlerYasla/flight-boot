package com.vafaill.flightboot.mapper;

import org.springframework.stereotype.Component;

import com.vafaill.flightboot.dao.concrete.AirportDAO;
import com.vafaill.flightboot.dto.airport.AirportDTO;

@Component
public class AirportMapper {

    // toDTO method
    public AirportDTO toAirportDTO(AirportDAO airportDAO) {
        AirportDTO airportDTO = new AirportDTO();

        airportDTO.setCity(airportDAO.getCity());

        return airportDTO;
    }

    // toDAO method
    public AirportDAO toAirportDAO(AirportDTO airportDTO) {
        // Create new GUID
        long id = System.currentTimeMillis();

        AirportDAO airportDAO = new AirportDAO(id, airportDTO.getCity());

        return airportDAO;
    }
}
