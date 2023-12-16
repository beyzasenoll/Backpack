package com.backpack.BackpackTravelApp.service;

import com.backpack.BackpackTravelApp.dto.airfranceapi.getFlightStatusRequest.GetFlightStatusRequest;
import com.backpack.BackpackTravelApp.dto.airfranceapi.getFlightStatusResponse.FlightResponse;
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

    @Value("${airfrance.api.host}")
    private String hostName;

    @Value("${airfrance.api.content.type}")
    private String contentType;
    @Autowired
    private RestTemplate restTemplate;

   Logger logger = LoggerFactory.getLogger(AirFranceService.class);

    public double fetchTotalPrice(GetFlightStatusRequest getFlightStatus) {
        logger.info("Fetching total price from Air France API...");

        logger.info(getFlightStatus.getBookingFlow());


        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Content-Type", contentType);
        httpHeaders.set("API-Key", apiKey);
        httpHeaders.set("AFKL-TRAVEL-Host", hostName);

        HttpEntity<GetFlightStatusRequest> requestEntity =
                new HttpEntity<>(getFlightStatus, httpHeaders);

        logger.info("Sending request to Air France API: {}", apiUrl);
        logger.info("Request body: {}", httpHeaders);


        try {
            ResponseEntity<FlightResponse> responseEntity = restTemplate.exchange(apiUrl, HttpMethod.POST, requestEntity, FlightResponse.class);

            logger.info("Received response from Air France API: {}", responseEntity);
            logger.info("Response status code: {}", responseEntity.getStatusCode());

            if (responseEntity.getStatusCode().is2xxSuccessful()) {
                FlightResponse airFranceApiResponse = responseEntity.getBody();
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
