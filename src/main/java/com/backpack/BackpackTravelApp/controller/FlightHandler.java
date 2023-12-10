package com.backpack.BackpackTravelApp.controller;

import com.backpack.BackpackTravelApp.model.FlightInput;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class FlightHandler {

    private String thyService;

    private String airFrance;


    public List<String> findCheapestWay(FlightInput flightInput) {


        //algoritmayı çağıracağız
        //


        return null;
    }
}
