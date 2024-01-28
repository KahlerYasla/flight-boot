package com.vafaill.flightboot.repo;

import org.springframework.data.repository.CrudRepository;

import com.vafaill.flightboot.model.concrete.Airport;

public interface AirportRepo extends CrudRepository<Airport, Long> {
    // Auto-implemented by Spring CrudRepository
}
