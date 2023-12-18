package com.backpack.BackpackTravelApp.infrastructure.external.airfrance;

import com.backpack.BackpackTravelApp.dto.FlightDetailRequestDto;
import com.backpack.BackpackTravelApp.infrastructure.external.airfrance.request.AirFranceFlightRequest;
import com.backpack.BackpackTravelApp.infrastructure.external.airfrance.response.AirFranceFlightResponse;
import com.backpack.BackpackTravelApp.mapper.airfrance.AirFranceRequestMapper;
import com.backpack.BackpackTravelApp.service.AirFranceService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@NoArgsConstructor
@AllArgsConstructor
public class AirFranceApiConnector {
    //TODO add test
    Logger logger = LoggerFactory.getLogger(AirFranceService.class);
    @Value("${airfrance.api.key}")
    private String apiKey;
    @Value("${airfranceklm.api.url}")
    private String apiUrl;
    @Value("${airfrance.api.host}")
    private String hostName;
    @Value("${airfrance.api.content.type}")
    private String contentType;
    public RestTemplate restTemplate;


    public AirFranceFlightResponse getAirFranceFlightDetails(FlightDetailRequestDto flightDetailRequestDto) {

        AirFranceRequestMapper airFranceRequestMapper= new AirFranceRequestMapper();
        AirFranceFlightRequest airFranceFlightRequest = airFranceRequestMapper.mapToGetAirFranceFlightRequest(flightDetailRequestDto);


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