package com.vafaill.flightboot.dao.concrete;

import com.vafaill.flightboot.dao.base.BaseDAO;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "airports")
public class AirportDAO extends BaseDAO {

    private String city;

    // Constructors, getters, setters
}
