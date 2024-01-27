package com.vafaill.flightboot.mapper;

import org.springframework.stereotype.Component;

import com.vafaill.flightboot.dao.concrete.AirportDAO;
import com.vafaill.flightboot.dao.concrete.FlightDAO;
import com.vafaill.flightboot.dto.flight.FlightDTO;

@Component
public class FlightMapper {

    // #region toDTO methods
    public FlightDTO toFlightDTO(FlightDAO flightDAO) {
        FlightDTO flightDTO = new FlightDTO();

        flightDTO.setArrivalCityName(flightDAO.getArrivalAirport().getCity());
        flightDTO.setDepartureCityName(flightDAO.getDepartureAirport().getCity());
        flightDTO.setDepartureDateTime(flightDAO.getDepartureDateTime());
        flightDTO.setReturnDateTime(flightDAO.getReturnDateTime());
        flightDTO.setPrice(flightDAO.getPrice());

        return flightDTO;
    }
    // #endregion

    // #region toDAO methods
    public FlightDAO toFlightDAO(FlightDTO flightDTO) {
        // Create new GUID
        long id = System.currentTimeMillis();

        // Create Arrival Airport and Departure Airport
        AirportDAO arrivalAirport = new AirportDAO(id, flightDTO.getArrivalCityName());
        AirportDAO departureAirport = new AirportDAO(id, flightDTO.getDepartureCityName());

        FlightDAO flightDAO = new FlightDAO(id, departureAirport, arrivalAirport, flightDTO.getDepartureDateTime(),
                flightDTO.getReturnDateTime(), flightDTO.getPrice());

        return flightDAO;
    }
    // #endregion
}
