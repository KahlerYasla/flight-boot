package com.vafaill.flightboot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vafaill.flightboot.repo.AirportRepo;

@Service
public class AirportService {

    @Autowired
    private AirportRepo _airportRepo;
}
