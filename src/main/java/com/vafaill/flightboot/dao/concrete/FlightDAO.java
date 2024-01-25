package com.vafaill.flightboot.dao.concrete;

import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import com.vafaill.flightboot.dao.base.BaseDAO;

@Entity
@Table(name = "flights")
public class FlightDAO extends BaseDAO {

    @ManyToOne
    @JoinColumn(name = "departure_airport_id")
    private AirportDAO departureAirport;

    @ManyToOne
    @JoinColumn(name = "arrival_airport_id")
    private AirportDAO arrivalAirport;

    @Column(name = "departure_datetime")
    private LocalDateTime departureDateTime;

    @Column(name = "return_datetime")
    private LocalDateTime returnDateTime;

    private double price;

    // Constructors, getters, setters
}
