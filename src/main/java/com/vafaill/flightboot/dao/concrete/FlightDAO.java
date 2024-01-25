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

    // #region Getters and Setters
    public AirportDAO getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(AirportDAO departureAirport) {
        this.departureAirport = departureAirport;
    }

    public AirportDAO getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(AirportDAO arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    public LocalDateTime getDepartureDateTime() {
        return departureDateTime;
    }

    public void setDepartureDateTime(LocalDateTime departureDateTime) {
        this.departureDateTime = departureDateTime;
    }

    public LocalDateTime getReturnDateTime() {
        return returnDateTime;
    }

    public void setReturnDateTime(LocalDateTime returnDateTime) {
        this.returnDateTime = returnDateTime;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    // #endregion Getters and Setters
}
