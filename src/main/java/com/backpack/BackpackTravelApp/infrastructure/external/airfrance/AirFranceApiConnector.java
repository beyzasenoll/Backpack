package com.backpack.BackpackTravelApp.infrastructure.external.airfrance;

import com.backpack.BackpackTravelApp.dto.FlightRequestDto;
import com.backpack.BackpackTravelApp.infrastructure.external.airfrance.request.AirFranceFlightRequest;
import com.backpack.BackpackTravelApp.infrastructure.external.airfrance.response.AirFranceFlightResponse;
import com.backpack.BackpackTravelApp.mapper.airfrance.AirFranceRequestMapper;
import com.backpack.BackpackTravelApp.service.AirFranceService;
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

@NoArgsConstructor
@AllArgsConstructor
@Component
public class AirFranceApiConnector {
    //TODO add test
    Logger logger = LoggerFactory.getLogger(AirFranceService.class);
    @Value("${air.france.api.key}")
    private String apiKey;
    @Value("${air.france.klm.api.url}")
    private String apiUrl;

    @Value("${air.france.api.host}")
    private String hostName;
    @Value("${air.france.api.content.type}")
    private String contentType;

    @Autowired
    RestTemplate restTemplate;

    @PostConstruct
    private void initializeRestTemplate() {
        if (apiKey == null || apiUrl == null || hostName == null || contentType == null) {
            throw new IllegalStateException("One or more required properties are null. Cannot initialize RestTemplate.");
        }

        restTemplate = new RestTemplate();
    }
    public AirFranceFlightResponse getAirFranceFlightDetails(FlightRequestDto flightRequestDto) {

        AirFranceRequestMapper airFranceRequestMapper= new AirFranceRequestMapper();
        AirFranceFlightRequest airFranceFlightRequest = airFranceRequestMapper.mapToGetAirFranceFlightRequest(flightRequestDto);


        HttpHeaders httpHeaders = prepareHttpHeaders();
        HttpEntity<AirFranceFlightRequest> requestEntity = new HttpEntity<>(airFranceFlightRequest, httpHeaders);
        try {
            ResponseEntity<AirFranceFlightResponse> responseEntity = restTemplate.exchange(apiUrl, HttpMethod.POST, requestEntity, AirFranceFlightResponse.class);

            if (responseEntity.getStatusCode().is2xxSuccessful()) {
                return responseEntity.getBody();
            } else {
                handleHttpError(responseEntity);
            }
        } catch (Exception e) {
            handleUnexpectedError(e);
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