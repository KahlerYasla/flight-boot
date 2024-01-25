package com.vafaill.flightboot.dao.concrete;

import com.vafaill.flightboot.dao.base.BaseDAO;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "airports")
public class AirportDAO extends BaseDAO {

    private String city;

    // #region Getters and Setters
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    // #endregion
}
