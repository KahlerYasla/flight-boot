package com.vafaill.flightboot.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class AuthController {

    @GetMapping("/")
    public String index() {
        return "Successfull request to /";
    }

    @GetMapping("/{id}")
    public String requestWithId(@PathVariable int id) {
        return "Request with id: " + id;
    }

}
