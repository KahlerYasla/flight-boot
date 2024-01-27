package com.vafaill.flightboot.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vafaill.flightboot.dao.concrete.AirportDAO;
import com.vafaill.flightboot.dao.concrete.FlightDAO;
import com.vafaill.flightboot.dto.flight.FlightDTO;
import com.vafaill.flightboot.repo.FlightRepo;

@Component
public class FlightMapper {

    @Autowired
    private FlightRepo _flightRepo;

    // #region toDTO methods
    public FlightDTO toFlightDTO(FlightDAO flightDAO) {
        FlightDTO flightDTO = new FlightDTO();

        flightDTO.setId(flightDAO.getId());
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
        long id = 0;

        // Find if there is a flight with the same properties
        Iterable<FlightDAO> flightDAOs = _flightRepo.findAll();

        for (FlightDAO flightDAO : flightDAOs) {
            if (flightDAO.getDepartureAirport().getCity().equals(flightDTO.getDepartureCityName()) &&
                    flightDAO.getArrivalAirport().getCity().equals(flightDTO.getArrivalCityName()) &&
                    flightDAO.getDepartureDateTime().equals(flightDTO.getDepartureDateTime()) &&
                    flightDAO.getReturnDateTime().equals(flightDTO.getReturnDateTime()) &&
                    flightDAO.getPrice() == flightDTO.getPrice()) {
                id = flightDAO.getId();
            }
        }

        if (id == 0) {
            // New id
            id = flightDAOs.spliterator().getExactSizeIfKnown() + 1;
        }

        // Create Arrival Airport and Departure Airport
        AirportDAO arrivalAirport = new AirportDAO(id, flightDTO.getArrivalCityName());
        AirportDAO departureAirport = new AirportDAO(id, flightDTO.getDepartureCityName());

        FlightDAO flightDAO = new FlightDAO(id, departureAirport, arrivalAirport, flightDTO.getDepartureDateTime(),
                flightDTO.getReturnDateTime(), flightDTO.getPrice());

        return flightDAO;
    }
    // #endregion
}
