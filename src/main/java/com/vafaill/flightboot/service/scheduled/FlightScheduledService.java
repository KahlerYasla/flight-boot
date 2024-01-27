package com.vafaill.flightboot.service.scheduled;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.vafaill.flightboot.dto.flight.req.FlightFromThirdApiDTO;
import com.vafaill.flightboot.service.FlightService;

@Service
public class FlightScheduledService {

    @Autowired
    private FlightService flightService;

    // Run every 10 seconds
    @Scheduled(fixedRate = 10000)
    public void fetchAndSaveFlightData() throws URISyntaxException, IOException, InterruptedException {

        HttpClient httpClient = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://jsonplaceholder.typicode.com/posts/1"))
                .GET()
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("Response Code: " + response.statusCode());
        System.out.println("Response Body: " + response.body());

        FlightFromThirdApiDTO flightFromThirdApiDTO = new FlightFromThirdApiDTO();

        // TODO: Map JSON to DTO

        flightService.fetchFlightDataFromThirdPartyAPI();
    }
}
