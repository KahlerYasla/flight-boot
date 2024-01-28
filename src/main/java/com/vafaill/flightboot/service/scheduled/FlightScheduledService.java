// package com.vafaill.flightboot.service.scheduled;

// import java.io.IOException;
// import java.net.URI;
// import java.net.URISyntaxException;
// import java.net.http.HttpClient;
// import java.net.http.HttpRequest;
// import java.net.http.HttpResponse;
// import java.util.Map;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.scheduling.annotation.Scheduled;
// import org.springframework.stereotype.Service;

// import com.vafaill.flightboot.dto.flight.req.FlightFromThirdApiDTO;
// import com.vafaill.flightboot.service.FlightService;

// @Service
// public class FlightScheduledService {

// @Autowired
// private FlightService flightService;

// // Run every 30 seconds
// @Scheduled(fixedRate = 30000)
// public void fetchAndSaveFlightData() throws URISyntaxException, IOException,
// InterruptedException {
// // Prepare request parameters
// Map<String, String> params = Map.of(
// "to", "LHE",
// "from", "DXB",
// "depart-date", "2015-03-31",
// "return-date", "2015-04-07");

// // Build URI with query parameters
// URI uri =
// buildUriWithParams("https://test.api.amadeus.com/v1/shopping/flight-destinations",
// params);

// // Build the HttpRequest
// HttpRequest request = HttpRequest.newBuilder()
// .uri(uri)
// .header("", "e287c0e5ddmsha0042f63c38de1dp1d3c24jsn4cbc5c75dc9d")
// .header("X-RapidAPI-Host", "siddiq-such-flight-v1.p.rapidapi.com")
// .GET()
// .build();

// // Create HttpClient
// HttpClient httpClient = HttpClient.newHttpClient();

// // Send the request and get the response
// HttpResponse<String> response = httpClient.send(request,
// HttpResponse.BodyHandlers.ofString());

// // Print the response body
// System.out.println("Response Headers: " + response.headers());
// System.out.println("Response Code: " + response.statusCode());
// System.out.println("Response Body: " + response.body());

// FlightFromThirdApiDTO flightFromThirdApiDTO = new FlightFromThirdApiDTO();

// // TODO: Map JSON to DTO

// flightService.fetchFlightDataFromThirdPartyAPI();
// }

// private static URI buildUriWithParams(String baseUrl, Map<String, String>
// params) throws URISyntaxException {
// StringBuilder uriBuilder = new StringBuilder(baseUrl);
// uriBuilder.append("?");
// for (Map.Entry<String, String> entry : params.entrySet()) {
// uriBuilder.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
// }
// uriBuilder.deleteCharAt(uriBuilder.length() - 1); // Remove the trailing "&"
// return new URI(uriBuilder.toString());
// }
// }
