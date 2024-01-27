package com.vafaill.flightboot.dto.airport.req;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AirportNameUpdateDTO {
    private String oldCity;
    private String newCity;
}
