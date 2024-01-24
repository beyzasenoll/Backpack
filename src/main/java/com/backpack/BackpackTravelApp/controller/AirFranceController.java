package com.backpack.BackpackTravelApp.controller;

import com.backpack.BackpackTravelApp.dto.FlightRequestDto;
import com.backpack.BackpackTravelApp.dto.FlightResponseDto;
import com.backpack.BackpackTravelApp.infrastructure.external.airfrance.airFranceClient_2.AirFranceApiConnector;
import com.backpack.BackpackTravelApp.infrastructure.external.airfrance.airFranceClient_2.request.RequestRoot;
import com.backpack.BackpackTravelApp.infrastructure.external.airfrance.airFranceClient_2.response.ResponseRoot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AirFranceController {

    private final AirFranceApiConnector airFranceApiConnector;

    @Autowired
    public AirFranceController(AirFranceApiConnector airFranceApiConnector) {
        this.airFranceApiConnector = airFranceApiConnector;
    }

    @PostMapping("/total-price1")
    public ResponseEntity<ResponseRoot> fetchTotalPrice(@RequestBody RequestRoot requestRoot) {
        try {
            ResponseRoot responseRoot = airFranceApiConnector.getAirFranceFlightDetails(requestRoot, new ResponseRoot());
            return new ResponseEntity<>(responseRoot, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}


