package com.backpack.BackpackTravelApp.controller;

import com.backpack.BackpackTravelApp.model.FlightInput;
import com.backpack.BackpackTravelApp.model.FlightInputRequest;
import lombok.Data;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Service
@Data
@RestController
public class FlightHandler {

    private String airPlaneService; //?
    private String thyService;

    private String airFranceService;

    public List<String> findCheapestWay(FlightInput flightInput) {

        return null;
    }
    public String findMinimumPrice(FlightInput flightInputRequest, FlightInput flightInput){

        return null;
    }
}
