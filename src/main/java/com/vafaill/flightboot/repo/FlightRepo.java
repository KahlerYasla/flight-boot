package com.vafaill.flightboot.repo;

import org.springframework.data.repository.CrudRepository;
import com.vafaill.flightboot.dao.concrete.FlightDAO;

public interface FlightRepo extends CrudRepository<FlightDAO, Long> {
    // Auto-implemented by Spring CrudRepository
}
