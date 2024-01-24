package com.backpack.BackpackTravelApp.controller;

import com.backpack.BackpackTravelApp.infrastructure.external.airfrance.airFrance.AirfranceApiConnector;
import com.backpack.BackpackTravelApp.infrastructure.external.airfrance.airFrance.request.RequestRoot;
import com.backpack.BackpackTravelApp.infrastructure.external.airfrance.airFrance.response.ResponseRoot;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/api")
public class AirFranceController {
        @PostMapping("/all-price")
        public ResponseEntity<ResponseRoot> fetchTotalPrice(@RequestBody RequestRoot requestRoot) {
            try {
                ResponseRoot responseRoot = AirfranceApiConnector.getAirFranceFlightDetails2(requestRoot, new ResponseRoot());
                return new ResponseEntity<>(responseRoot, HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

