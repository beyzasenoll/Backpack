package com.backpack.BackpackTravelApp.controller;

//import com.backpack.BackpackTravelApp.model.airFranceModel.FlightDetails;

import com.backpack.BackpackTravelApp.service.AirFranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AirFranceController {

    private final AirFranceService airFranceService;

    @Autowired
    public AirFranceController(AirFranceService airFranceService) {
        this.airFranceService = airFranceService;
    }

    @PostMapping("/getFlightStatus")
    public void fetchTotalPrice(@RequestBody GetFlightStatusRequest getFlightStatus) {
        airFranceService.fetchTotalPrice(getFlightStatus);
    }
}


