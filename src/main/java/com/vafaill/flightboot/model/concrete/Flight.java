package com.vafaill.flightboot.model.concrete;

import java.time.LocalDateTime;

import com.vafaill.flightboot.model.base.BaseModel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "flights")
@lombok.Data
public class Flight extends BaseModel {

    @ManyToOne
    @JoinColumn(name = "departure_airport_id")
    private Airport departureAirport;

    @ManyToOne
    @JoinColumn(name = "arrival_airport_id")
    private Airport arrivalAirport;

    @Column(name = "departure_datetime")
    private LocalDateTime departureDateTime;

    @Column(name = "return_datetime", nullable = true)
    private LocalDateTime returnDateTime;

    private Double price;

    public Flight(Airport departureAirport, Airport arrivalAirport, LocalDateTime departureDateTime,
            LocalDateTime returnDateTime, Double price) {
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.departureDateTime = departureDateTime;
        this.returnDateTime = returnDateTime;
        this.price = price;
    }

}
