package com.vafaill.flightboot.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vafaill.flightboot.dto.flight.FlightDTO;
import com.vafaill.flightboot.model.concrete.Airport;
import com.vafaill.flightboot.model.concrete.Flight;
import com.vafaill.flightboot.repo.AirportRepo;
import com.vafaill.flightboot.repo.FlightRepo;

@Component
public class FlightMapper {

    @Autowired
    private FlightRepo _flightRepo;

    @Autowired
    private AirportRepo _airportRepo;

    // #region toDTO methods
    public FlightDTO toFlightDTO(Flight flightDAO) {
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
    public Flight toFlightDAO(FlightDTO flightDTO) {
        long id = 0;

        // Find if there is a flight with the same properties
        Iterable<Flight> flightDAOs = _flightRepo.findAll();

        for (Flight flightDAO : flightDAOs) {
            if (flightDAO.getDepartureAirport().getCity().equals(flightDTO.getDepartureCityName()) &&
                    flightDAO.getArrivalAirport().getCity().equals(flightDTO.getArrivalCityName()) &&
                    flightDAO.getDepartureDateTime().equals(flightDTO.getDepartureDateTime()) &&
                    flightDAO.getReturnDateTime().equals(flightDTO.getReturnDateTime()) &&
                    flightDAO.getPrice() == flightDTO.getPrice()) {
                id = flightDAO.getId();
            }
        }

        // Get arrival and departure airports
        Airport departureAirport = null;
        Airport arrivalAirport = null;

        Iterable<Airport> airportDAOs = _airportRepo.findAll();

        for (Airport airportDAO : airportDAOs) {
            if (airportDAO.getCity().equals(flightDTO.getDepartureCityName())) {
                departureAirport = airportDAO;
            }
            if (airportDAO.getCity().equals(flightDTO.getArrivalCityName())) {
                arrivalAirport = airportDAO;
            }
        }

        // If departureAirport or arrivalAirport is null, throw an exception
        if (departureAirport == null || arrivalAirport == null) {
            throw new NullPointerException("Departure or arrival airport is null");
        }

        Flight flightDAO = new Flight(departureAirport, arrivalAirport, flightDTO.getDepartureDateTime(),
                flightDTO.getReturnDateTime(), flightDTO.getPrice());

        return flightDAO;
    }
    // #endregion
}
