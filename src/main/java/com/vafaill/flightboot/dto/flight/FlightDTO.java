package com.vafaill.flightboot.dto.flight;

import java.time.LocalDateTime;
import java.util.Optional;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class FlightDTO {
    private String departureCityName;
    private String arrivalCityName;
    private LocalDateTime departureDateTime;
    private Optional<LocalDateTime> returnDateTime;
    private Double price;
}
