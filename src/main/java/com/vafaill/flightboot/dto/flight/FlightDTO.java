package com.vafaill.flightboot.dto.flight;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class FlightDTO {
    private long id;
    private String departureCityName;
    private String arrivalCityName;
    private LocalDateTime departureDateTime;
    private LocalDateTime returnDateTime;
    private Double price;
}
