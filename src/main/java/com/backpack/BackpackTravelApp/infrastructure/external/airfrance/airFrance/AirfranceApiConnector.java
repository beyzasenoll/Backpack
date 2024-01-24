package com.backpack.BackpackTravelApp.infrastructure.external.airfrance.airFrance;

import com.backpack.BackpackTravelApp.infrastructure.external.airfrance.airFranceClient_1.request.AirFranceFlightRequest;
import com.backpack.BackpackTravelApp.infrastructure.external.airfrance.airFrance.request.RequestRoot;
import com.backpack.BackpackTravelApp.infrastructure.external.airfrance.airFrance.response.ResponseRoot;
import com.backpack.BackpackTravelApp.service.airfrance.AirFranceClient_1.AirFranceService;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class AirfranceApiConnector {
    static Logger logger = LoggerFactory.getLogger(AirFranceService.class);

    //TODO add test
        @Value("${air.france.api.key}")
        private static String apiKey;
        @Value("${air.france.klm.api.url.client2}")
        private static String apiUrl;

        @Value("${air.france.api.host}")
        private static String hostName;
        @Value("${air.france.api.content.type}")
        private static String contentType;

        //@Autowired
        static RestTemplate restTemplate;

        @PostConstruct
        private void initializeRestTemplate() {
            if (apiKey == null || apiUrl == null || hostName == null || contentType == null) {
                throw new IllegalStateException("One or more required properties are null. Cannot initialize RestTemplate.");
            }

            restTemplate = new RestTemplate();
        }
        public static ResponseRoot getAirFranceFlightDetails2(RequestRoot RequestRoot, ResponseRoot responseRoot) {

            HttpHeaders httpHeaders = prepareHttpHeaders();
            HttpEntity<RequestRoot> requestEntity = new HttpEntity<>(RequestRoot, httpHeaders);
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

            return responseRoot;
        }

        private static HttpHeaders prepareHttpHeaders() {
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.set("Content-Type", contentType);
            httpHeaders.set("API-Key", apiKey);
            httpHeaders.set("AFKL-TRAVEL-Host", hostName);
            return httpHeaders;
        }

        private static void handleHttpError(ResponseEntity<?> responseEntity) {
            logger.error("Error fetching Air France flight details. Status code: {}", responseEntity.getStatusCodeValue());
        }

        private static void handleUnexpectedError(Exception e) {
            logger.error("Unexpected error occurred", e);
        }

    }
