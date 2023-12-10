package com.backpack.BackpackTravelApp.controller;
import com.backpack.BackpackTravelApp.model.FlightInput;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Date;

@RestController
@AllArgsConstructor
@RequestMapping("/api/flights")
public class FlightController {
    @Autowired
    private FlightHandler flightHandler;

    @GetMapping("/flights")
    @ResponseBody
    public void getFlights (@RequestParam Date departureDate,
                                   @RequestParam String departureCity,
                                   @RequestParam String cities_to_visit_1,
                                   @RequestParam String cities_to_visit_2,
                                   @RequestParam String cities_to_visit_3)
    {

        FlightInput flightInput = new FlightInput();
        flightInput.setDepartureDate(departureDate);
        flightInput.setDepartureCity(departureCity);
        flightInput.setCities_to_visit_1(cities_to_visit_1);
        flightInput.setCities_to_visit_2(cities_to_visit_2);
        flightInput.setCities_to_visit_3(cities_to_visit_3);


    }

}

