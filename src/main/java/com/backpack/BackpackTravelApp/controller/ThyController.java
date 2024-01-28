package com.backpack.BackpackTravelApp.controller;

import com.backpack.BackpackTravelApp.dto.thy.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/travel")
public class ThyController {
    private final ThyApiService thyApiService;

    @Autowired
    public ThyController(ThyApiService thyApiService) {
        this.thyApiService = thyApiService;
    }

    @GetMapping("/{flightId}")
    public Example getTravelInfo(@PathVariable String flightId) {
        // You can add additional validation or error handling here
        return thyApiService.getTravelInfo(flightId);
    }
}
