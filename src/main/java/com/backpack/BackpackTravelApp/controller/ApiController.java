package com.backpack.BackpackTravelApp.controller;

import com.backpack.BackpackTravelApp.service.AirFranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {

    private final AirFranceService airFranceService;

    @Autowired
    public ApiController(AirFranceService airFranceService) {
        this.airFranceService = airFranceService;
    }

    @GetMapping("/getFlightStatus")
    public void getFlightStatus() {
        airFranceService.printTotalPrice();
    }
}
