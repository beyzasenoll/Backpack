package com.backpack.BackpackTravelApp.service;

import com.backpack.BackpackTravelApp.dto.airfranceapi.AirFranceApiDto;
import com.backpack.BackpackTravelApp.dto.airfranceapi.getFlightStatusRequest.GetFlightStatusRequest;
import com.backpack.BackpackTravelApp.dto.airfranceapi.getFlightStatusResponse.DestinationCity;
import com.backpack.BackpackTravelApp.dto.airfranceapi.getFlightStatusResponse.FlightProduct;
import com.backpack.BackpackTravelApp.dto.airfranceapi.getFlightStatusResponse.FlightResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class AirFranceService {

    Logger logger = LoggerFactory.getLogger(AirFranceService.class);
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

    public AirFranceApiDto fetchTotalPrice(GetFlightStatusRequest getFlightStatus, AirFranceApiDto airFranceApiDto) {
        logger.info("Fetching total price from Air France API...");

        HttpHeaders httpHeaders = prepareHttpHeaders();
        HttpEntity<GetFlightStatusRequest> requestEntity = new HttpEntity<>(getFlightStatus, httpHeaders);

        try {
            ResponseEntity<FlightResponse> responseEntity = restTemplate.exchange(apiUrl, HttpMethod.POST, requestEntity, FlightResponse.class);

            logger.info("Received response from Air France API: {}", responseEntity);
            logger.info("Response status code: {}", responseEntity.getStatusCode());

            if (responseEntity.getStatusCode().is2xxSuccessful()) {
                FlightResponse airFranceApiResponse = responseEntity.getBody();
                String originCode = airFranceApiResponse.getOrigin();
                double minTotalPrice = Double.MAX_VALUE;
                String minTotalPriceCity = null;
                String departureDate = null;
                String returnDate = null;

                for (DestinationCity destinationCity : airFranceApiResponse.getDestinationCities()) {
                    for (FlightProduct flightProduct : destinationCity.getFlightProducts()) {
                        double currentTotalPrice = flightProduct.getPrice().getTotalPrice();
                        if (currentTotalPrice < minTotalPrice) {
                            minTotalPrice = currentTotalPrice;
                            minTotalPriceCity = destinationCity.getName();
                            departureDate = flightProduct.getDepartureDate();
                            returnDate = flightProduct.getReturnDate();
                        }
                    }
                }

                return new AirFranceApiDto(originCode, minTotalPriceCity, departureDate, returnDate, minTotalPrice);
            } else {
                logger.error("Error fetching total price: {}", responseEntity.getStatusCodeValue());
            }
        } catch (Exception e) {
            logger.error("Unexpected error occurred", e);
        }

        return airFranceApiDto;
    }


    private HttpHeaders prepareHttpHeaders() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Content-Type", contentType);
        httpHeaders.set("API-Key", apiKey);
        httpHeaders.set("AFKL-TRAVEL-Host", hostName);
        return httpHeaders;
    }
}
