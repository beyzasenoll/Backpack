package com.backpack.BackpackTravelApp.controller;


import com.backpack.BackpackTravelApp.dto.FlightRequestDto;
import com.backpack.BackpackTravelApp.infrastructure.external.airfrance.AirFranceApiConnector;
import com.backpack.BackpackTravelApp.infrastructure.external.airfrance.request.RequestRoot;
import com.backpack.BackpackTravelApp.infrastructure.external.airfrance.response.ResponseRoot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AirFranceController {

    private final AirFranceApiConnector airFranceApiConnector;

    @Autowired
    public AirFranceController(AirFranceApiConnector airFranceApiConnector) {
        this.airFranceApiConnector = airFranceApiConnector;
    }

    @PostMapping("/all-prices")
    public ResponseEntity<ResponseRoot> fetchTotalPrice(@RequestBody RequestRoot requestRoot) {
        try {
            ResponseRoot responseRoot = airFranceApiConnector.getAirFranceFlightDetails(requestRoot, new ResponseRoot());
            return new ResponseEntity<>(responseRoot, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

        @PostMapping("/createConnections")
        public ResponseEntity<List<ResponseRoot>> createConnections(@RequestBody FlightRequestDto flightRequest) {
            try {
                List<ResponseRoot> responseRootList = airFranceApiConnector.getAirFranceFlightsInformation(flightRequest);
                return new ResponseEntity<>(responseRootList, HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }



