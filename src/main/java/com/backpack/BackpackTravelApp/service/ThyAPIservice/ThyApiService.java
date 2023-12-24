package com.backpack.BackpackTravelApp.service.ThyAPIservice;

import com.backpack.BackpackTravelApp.model.thyModel.FlightResponse;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.http.HttpHeaders;

@Data
@Service
public class ThyApiService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HttpHeaders httpHeaders;
    public double getTotalPrice(){
        StringBuilder urlBuilder = new StringBuilder("https://api.turkishairlines.com/test/getAvailability");

        httpHeaders.set("Content-Type", "application/json");
        httpHeaders.set("apisecret", "2ef87fa129aa405eaf481881c2a7aeb1");
        httpHeaders.set("apikey", "l7xxdb2f2877af1f4fc39f40b95f76bf4c4e");


        HttpEntity<String> entity = new HttpEntity<>(httpHeaders);

        try {
            ResponseEntity<FlightResponse> responseEntity = restTemplate.exchange("https://api.turkishairlines.com/test/getAvailability", HttpMethod.POST, entity, FlightResponse.class);

            // Check for successful response
            if (responseEntity.getStatusCode().is2xxSuccessful()) {
                FlightResponse airFranceApiResponse = responseEntity.getBody();

                // Extract and return total price
                double totalPrice = airFranceApiResponse.getDestinationCities().get(0).getFlightProducts().get(0).getPrice().getTotalPrice();

                return totalPrice;
            } else {

                return 0;
            }
        } catch (Exception e) {
            return 0;
        }


        return 0;
    }

}
