package com.vafaill.flightboot.repo;

import org.springframework.data.repository.CrudRepository;

import com.vafaill.flightboot.model.concrete.Flight;

public interface FlightRepo extends CrudRepository<Flight, Long> {
    // Auto-implemented by Spring CrudRepository
}
