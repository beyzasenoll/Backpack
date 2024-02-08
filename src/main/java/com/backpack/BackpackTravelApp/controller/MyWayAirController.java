package com.backpack.BackpackTravelApp.controller;

import com.backpack.BackpackTravelApp.request.Request;
import com.backpack.BackpackTravelApp.service.MyWayApiService.MyWayApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyWayAirController {
    private MyWayApiService myWayApiService;

    @Autowired
    public MyWayAirController(MyWayApiService myWayApiService) {
        this.myWayApiService = myWayApiService;
    }

    @PostMapping("/getMaxPrice")
    public double getMaxPrice(@RequestBody Request request) {
        return myWayApiService.getMaxPrice(request);
    }
}
