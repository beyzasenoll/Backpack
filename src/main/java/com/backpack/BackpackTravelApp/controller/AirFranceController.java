package com.backpack.BackpackTravelApp.controller;

//import com.backpack.BackpackTravelApp.model.airFranceModel.FlightDetails;

import com.backpack.BackpackTravelApp.dto.airfranceapi.getFlightStatusRequest.GetFlightStatusRequest;
import com.backpack.BackpackTravelApp.service.AirFranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

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


