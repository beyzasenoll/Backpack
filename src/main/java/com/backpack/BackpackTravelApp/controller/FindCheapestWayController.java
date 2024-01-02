package com.backpack.BackpackTravelApp.controller;
import com.backpack.BackpackTravelApp.dto.FlightRequestDto;
import com.backpack.BackpackTravelApp.dto.FlightResponseDto;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/flights")
public class FindCheapestWayController {
    @Autowired
    private FindCheapestWayHandler airPlaneService;

    @GetMapping("/flightsInformations")
    public void getFlights (@RequestBody FlightRequestDto flightRequestDto){

    }
    @PostMapping("/total-price")
    public ResponseEntity<FlightResponseDto> fetchTotalPrice(@RequestBody FlightRequestDto getFlightRequestDto) {
        try {
            FlightResponseDto flightResponseDto = airPlaneService.findMinimumPrice(getFlightRequestDto, new FlightResponseDto());

            return new ResponseEntity<>(flightResponseDto, HttpStatus.OK);
            } catch (Exception e) {
               return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
}

