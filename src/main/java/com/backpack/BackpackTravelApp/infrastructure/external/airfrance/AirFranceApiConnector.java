package com.backpack.BackpackTravelApp.infrastructure.external.airfrance;

import com.backpack.BackpackTravelApp.dto.FlightRequestDto;
import com.backpack.BackpackTravelApp.handler.airfrance.FlightRequestHandler;
import com.backpack.BackpackTravelApp.infrastructure.external.airfrance.request.RequestRoot;
import com.backpack.BackpackTravelApp.infrastructure.external.airfrance.response.ResponseRoot;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Component
public class AirFranceApiConnector {

    @Autowired
    RestTemplate restTemplate;
    Logger logger = LoggerFactory.getLogger(AirFranceApiConnector.class);
    @Value("${air.france.api.key}")
    private String apiKey;
    @Value("${air.france.klm.api.url}")
    private String apiUrl;
    @Value("${air.france.api.host}")
    private String hostName;
    @Value("${air.france.api.content.type}")
    private String contentType;

    @PostConstruct
    private void initializeRestTemplate() {
        if (apiKey == null || apiUrl == null || hostName == null || contentType == null) {
            throw new IllegalStateException("One or more required properties are null. Cannot initialize RestTemplate.");
        }
        restTemplate = new RestTemplate();
    }

    public ResponseRoot getAirFranceFlightDetails(RequestRoot requestRoot, ResponseRoot responseRoot) {
        HttpHeaders httpHeaders = prepareHttpHeaders();
        logger.info("Prepared headers.");
        HttpEntity<RequestRoot> requestEntity = new HttpEntity<>(requestRoot, httpHeaders);
        logger.info("created request entity.");

        try {
            logger.info("creating response entity.");

            ResponseEntity<ResponseRoot> responseEntity = restTemplate.exchange(apiUrl, HttpMethod.POST, requestEntity, ResponseRoot.class);
            logger.info("created response entity.");
            if (responseEntity.getStatusCode().is2xxSuccessful()) {
                logger.info("Air France flight details fetched successfully.");
                return responseEntity.getBody();
            } else {
                handleHttpError(responseEntity);
            }
        } catch (Exception e) {
            handleUnexpectedError(e);
        }

        return null;
    }


    public List<ResponseRoot> getAirFranceFlightsInformation(FlightRequestDto flightRequest) {
        FlightRequestHandler flightRequestHandler = new FlightRequestHandler();
        List<RequestRoot> requestRoots = flightRequestHandler.generateRequestedConnections(flightRequest);

        HttpHeaders httpHeaders = prepareHttpHeaders();
        logger.info("Prepared headers.");
        List<ResponseRoot> allResponses = new ArrayList<>();

        for (RequestRoot requestRoot : requestRoots) {
            HttpEntity<RequestRoot> requestEntity = new HttpEntity<>(requestRoot, httpHeaders);
            logger.info("created request entity.");
            try {
                logger.info("Creating response entity.");
                ResponseEntity<ResponseRoot> responseEntity = restTemplate.exchange(apiUrl, HttpMethod.POST, requestEntity, ResponseRoot.class);
                logger.info("Created response entity.");

                if (responseEntity.getStatusCode().is2xxSuccessful()) {
                    logger.info("Air France flight details fetched successfully.");
                    allResponses.add(responseEntity.getBody());
                } else {
                    handleHttpError(responseEntity);
                }
            } catch (Exception e) {
                handleUnexpectedError(e);
            }

            // Introduce a 1-second delay
            try {
                Thread.sleep(1000); // Sleep for 1 second (1000 milliseconds)
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
        if (!allResponses.isEmpty()) {
            return allResponses;
        }

        return null;
    }

    public List<ResponseRoot> getAirFranceFlightsInformation(FlightRequestDto flightRequest) {
        FlightRequestHandler flightRequestHandler = new FlightRequestHandler();
        List<RequestRoot> requestRoots = flightRequestHandler.generateRequestedConnections(flightRequest);

        HttpHeaders httpHeaders = prepareHttpHeaders();
        logger.info("Prepared headers.");
        List<ResponseRoot> allResponses = new ArrayList<>();

        for (RequestRoot requestRoot : requestRoots) {
            HttpEntity<RequestRoot> requestEntity = new HttpEntity<>(requestRoot, httpHeaders);
            logger.info("created request entity.");
            try {
                logger.info("Creating response entity.");
                ResponseEntity<ResponseRoot> responseEntity = restTemplate.exchange(apiUrl, HttpMethod.POST, requestEntity, ResponseRoot.class);
                logger.info("Created response entity.");

                if (responseEntity.getStatusCode().is2xxSuccessful()) {
                    logger.info("Air France flight details fetched successfully.");
                    allResponses.add(responseEntity.getBody());
                } else {
                    handleHttpError(responseEntity);
                }
            } catch (Exception e) {
                handleUnexpectedError(e);
            }

            // Introduce a 1-second delay
            try {
                Thread.sleep(1000); // Sleep for 1 second (1000 milliseconds)
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
        if (!allResponses.isEmpty()) {
            return allResponses;
        }

        return null;
    }

    public ResponseRoot getAirFranceFlightsInformationV2(FlightRequestDto flightRequest) {
        FlightRequestHandler flightRequestHandler = new FlightRequestHandler();
        RequestRoot requestRoots = flightRequestHandler.generateRequestedConnections(flightRequest);

        HttpHeaders httpHeaders = prepareHttpHeaders();
        logger.info("Prepared headers.");
        List<ResponseRoot> allResponses = new ArrayList<>();

        for (RequestRoot requestRoot : requestRoots) {
            HttpEntity<RequestRoot> requestEntity = new HttpEntity<>(requestRoot, httpHeaders);
            logger.info("created request entity.");
            try {
                logger.info("Creating response entity.");
                ResponseEntity<ResponseRoot> responseEntity = restTemplate.exchange(apiUrl, HttpMethod.POST, requestEntity, ResponseRoot.class);
                logger.info("Created response entity.");

                if (responseEntity.getStatusCode().is2xxSuccessful()) {
                    logger.info("Air France flight details fetched successfully.");
                    allResponses.add(responseEntity.getBody());
                } else {
                    handleHttpError(responseEntity);
                }
            } catch (Exception e) {
                handleUnexpectedError(e);
            }

            // Introduce a 1-second delay
            try {
                Thread.sleep(1000); // Sleep for 1 second (1000 milliseconds)
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
        if (!allResponses.isEmpty()) {
            return allResponses;
        }

        return null;
    }

    private HttpHeaders prepareHttpHeaders() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Content-Type", contentType);
        httpHeaders.set("API-Key", apiKey);
        httpHeaders.set("AFKL-TRAVEL-Host", hostName);
        return httpHeaders;
    }

    private void handleHttpError(ResponseEntity<?> responseEntity) {
        logger.error("Error fetching Air France flight details. Status code: {}", responseEntity.getStatusCodeValue());
    }

    private void handleUnexpectedError(Exception e) {
        logger.error("Unexpected error occurred", e);
    }
}
