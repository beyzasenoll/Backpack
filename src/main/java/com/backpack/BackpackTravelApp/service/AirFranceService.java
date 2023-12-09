package com.backpack.BackpackTravelApp.service;

import com.backpack.BackpackTravelApp.model.airFranceModel.Price;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AirFranceService {

    @Value("${airfrance.api.key}")
    private String apiKey;

    @Value("${airfranceklm.api.url}")
    private String apiUrl;
    private final RestTemplate restTemplate;

    public AirFranceService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Price fetchDataFromApi() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("API-Key", apiKey);
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<String> entity = new HttpEntity<>(headers);
        return restTemplate.getForObject(apiUrl, Price.class, entity);
    }

    public void printTotalPrice() {
        Price flightResponse = fetchDataFromApi();
        double totalPrice = flightResponse.getTotalPrice();
        System.out.println("Total Price: " + totalPrice);
    }
}
