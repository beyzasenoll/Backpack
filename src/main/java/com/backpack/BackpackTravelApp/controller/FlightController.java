package com.backpack.BackpackTravelApp.controller;
import com.backpack.BackpackTravelApp.model.FlightInput;
import com.backpack.BackpackTravelApp.model.FlightInputRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Date;


@RestController
@AllArgsConstructor
@RequestMapping("/api/flights")
public class FlightController {
    @Autowired
    private FlightHandler airPlaneService;

    @GetMapping("/flightsInformations")
    public void getFlights (@RequestBody FlightInput flightInput){

    }

    @PostMapping("/total-price")
    public ResponseEntity<FlightInput> fetchTotalPrice(@RequestBody FlightInputRequest getFlightInputRequest) {
        try {
            FlightInput flightInput  = airPlaneService.findMinimumPrice(getFlightInputRequest, new FlightInputRequest());


            return new ResponseEntity<>( flightInput , HttpStatus.OK);
            } catch (Exception e) {
               return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }









}

