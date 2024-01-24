package com.backpack.BackpackTravelApp.infrastructure.external.airfrance.airFranceClient_2;

import com.backpack.BackpackTravelApp.infrastructure.external.airfrance.airFranceClient_2.request.RequestRoot;
import com.backpack.BackpackTravelApp.infrastructure.external.airfrance.airFranceClient_2.response.ResponseRoot;

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
        Logger logger = LoggerFactory.getLogger(AirFranceApiConnector.class);


        @PostConstruct
        private void initializeRestTemplate() {
            if (apiKey == null || apiUrl == null || hostName == null || contentType == null) {
                throw new IllegalStateException("One or more required properties are null. Cannot initialize RestTemplate.");
            }

            restTemplate = new RestTemplate();
        }
        public ResponseRoot getAirFranceFlightDetails(RequestRoot requestRoot, ResponseRoot responseRoot) {


            HttpHeaders httpHeaders = prepareHttpHeaders();
            HttpEntity<RequestRoot> requestEntity = new HttpEntity<>(requestRoot, httpHeaders);
            try {
                ResponseEntity<ResponseRoot> responseEntity = restTemplate.exchange(apiUrl, HttpMethod.POST, requestEntity, ResponseRoot.class);

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
