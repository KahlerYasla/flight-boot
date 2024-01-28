package com.vafaill.flightboot.model.concrete;

import com.vafaill.flightboot.model.base.BaseModel;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "airports")
public class Airport extends BaseModel {

    private String city;

    public Airport(String city) {
        this.city = city;
    }

    // #region Getters and Setters
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    // #endregion
}
