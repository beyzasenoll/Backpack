package com.backpack.BackpackTravelApp.service;

import com.backpack.BackpackTravelApp.controller.GetFlightStatusRequest;
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

   Logger logger = LoggerFactory.getLogger(AirFranceService.class);

    public double fetchTotalPrice(GetFlightStatusRequest getFlightStatus) {
        logger.info("Fetching total price from Air France API...");

        logger.info(getFlightStatus.getBookingFlow());

        //GetFlightStatusRequest getFlightStatusRequest = new GetFlightStatusRequest();
        //getFlightStatusRequest.setBookingFlow("dsdas");

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Content-Type", "application/json");
        httpHeaders.set("API-Key", apiKey);
        httpHeaders.set("AFKL-TRAVEL-Host", "KL");

        HttpEntity<GetFlightStatusRequest> requestEntity =
                new HttpEntity<>(getFlightStatus, httpHeaders);

        logger.info("Sending request to Air France API: {}", apiUrl);
        logger.info("Request body: {}", httpHeaders);


        //restTemplate.postForEntity()

        try {
            ResponseEntity<FlightResponse> responseEntity = restTemplate.exchange(apiUrl, HttpMethod.POST, requestEntity, FlightResponse.class);

            logger.info("Received response from Air France API: {}", responseEntity);
            logger.info("Response status code: {}", responseEntity.getStatusCode());

            if (responseEntity.getStatusCode().is2xxSuccessful()) {
                FlightResponse airFranceApiResponse = responseEntity.getBody();

                return 1L;
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
