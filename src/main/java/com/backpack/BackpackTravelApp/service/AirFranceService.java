package com.backpack.BackpackTravelApp.service;

import com.backpack.BackpackTravelApp.model.airFranceModel.FlightResponse;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.slf4j.LoggerFactory;

@Service
public class AirFranceService {

    @Value("${airfrance.api.key}")
    private String apiKey;

    @Value("${airfranceklm.api.url}")
    private String apiUrl;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HttpHeaders httpHeaders;

   Logger logger = LoggerFactory.getLogger(AirFranceService.class);

    public double fetchTotalPrice() {
        logger.info("Fetching total price from Air France API...");

        httpHeaders.set("Content-Type", "application/hal+json");
        httpHeaders.set("API-Key", "vsdvg7gyey6e9k2s5k84mntq");
        httpHeaders.set("AFKL-TRAVEL-Host", "KL");

        HttpEntity<String> entity = new HttpEntity<>(httpHeaders);

        logger.info("Sending request to Air France API: {}", apiUrl);
        logger.info("Request body: {}", httpHeaders);

        try {
            ResponseEntity<FlightResponse> responseEntity = restTemplate.exchange(apiUrl, HttpMethod.POST, entity, FlightResponse.class);

            logger.info("Received response from Air France API: {}", responseEntity);
            logger.info("Response status code: {}", responseEntity.getStatusCode());

            // Check for successful response
            if (responseEntity.getStatusCode().is2xxSuccessful()) {
                FlightResponse airFranceApiResponse = responseEntity.getBody();

                // Extract and return total price
                double totalPrice = airFranceApiResponse.getDestinationCities().get(0).getFlightProducts().get(0).getPrice().getTotalPrice();
                logger.info("Total price retrieved: {}", totalPrice);
                return totalPrice;
            } else {
                logger.error("Error fetching total price: {}", responseEntity.getStatusCodeValue());
                return 0;
            }
        } catch (Exception e) {
            logger.error("Unexpected error occurred", e);
            return 0;
        }
    }
}
