package com.vafaill.flightboot.repo;

import org.springframework.data.repository.CrudRepository;
import com.vafaill.flightboot.dao.concrete.AirportDAO;

public interface AirportRepo extends CrudRepository<AirportDAO, Long> {

}
