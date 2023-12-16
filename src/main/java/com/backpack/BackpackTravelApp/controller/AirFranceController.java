package com.backpack.BackpackTravelApp.controller;

import com.backpack.BackpackTravelApp.dto.airfranceapi.AirFranceApiDto;
import com.backpack.BackpackTravelApp.dto.airfranceapi.getFlightStatusRequest.GetFlightStatusRequest;
import com.backpack.BackpackTravelApp.service.AirFranceService;
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

    private final AirFranceService airFranceService;

    @Autowired
    public AirFranceController(AirFranceService airFranceApiService) {
        this.airFranceService = airFranceApiService;
    }

    @PostMapping("/total-price")
    public ResponseEntity<AirFranceApiDto> fetchTotalPrice(@RequestBody GetFlightStatusRequest getFlightStatus) {
        try {
            AirFranceApiDto airFranceApiDto = airFranceService.fetchTotalPrice(getFlightStatus, new AirFranceApiDto());
            return new ResponseEntity<>(airFranceApiDto, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}


