package com.vafaill.flightboot.service.scheduled;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.vafaill.flightboot.dto.flight.FlightDTO;
import com.vafaill.flightboot.dto.flight.req.FlightFromThirdApiDTO;
import com.vafaill.flightboot.model.concrete.Flight;
import com.vafaill.flightboot.service.FlightService;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class FlightScheduledService {

    @Autowired
    private FlightService flightService;

    // Run every 3000000 milliseconds (50 minutes)
    @Scheduled(fixedRate = 3000000)
    public void fetchAndSaveFlightData() throws URISyntaxException, IOException, InterruptedException {

        // Prepare request parameters
        Map<String, String> params = Map.of(
                "origin", "MAD",
                "oneWay", "false",
                "nonStop", "false");

        // Build URI with query parameters
        URI uri = buildUriWithParams("https://test.api.amadeus.com/v1/shopping/flight-destinations",
                params);

        // Build the HttpRequest
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .header("Authorization", "Bearer IEf8tN5GcfhxcgY7OG60B6M05IiZ")
                .GET()
                .build();

        // Create HttpClient
        HttpClient httpClient = HttpClient.newHttpClient();

        // Send the request and get the response
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        // Map JSON to DTO
        FlightDTO[] flights = mapJsonToDTO(response.body(), FlightDTO[].class);

        // Convert the DTO to DAO
        for (FlightDTO flight : flights) {
            flightService.addFlight(flight);
        }
    }

    private static URI buildUriWithParams(String baseUrl, Map<String, String> params) throws URISyntaxException {
        StringBuilder uriBuilder = new StringBuilder(baseUrl);
        uriBuilder.append("?");
        for (Map.Entry<String, String> entry : params.entrySet()) {
            uriBuilder.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
        }
        uriBuilder.deleteCharAt(uriBuilder.length() - 1); // Remove the trailing "&"
        return new URI(uriBuilder.toString());
    }

    private <T> T mapJsonToDTO(String json, Class<T> valueType) throws IOException {
        JsonNode jsonNode = new ObjectMapper().readTree(json);
        return new ObjectMapper().treeToValue(jsonNode, valueType);
    }
}
