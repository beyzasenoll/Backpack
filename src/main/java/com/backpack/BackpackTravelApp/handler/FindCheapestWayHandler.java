package com.backpack.BackpackTravelApp.handler;

import com.backpack.BackpackTravelApp.dto.FlightRequestDto;
import com.backpack.BackpackTravelApp.dto.FlightResponseDto;
import lombok.Data;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Service
@Data
@RestController
public class FindCheapestWayHandler {

    private String airPlaneService; //?
    private String thyService;
    private String airFranceService;
    public List<String> findCheapestWay(FlightResponseDto flightResponseDto) {

        return null;
    }
    
    public FlightResponseDto findMinimumPrice(FlightRequestDto getFlightRequestDto, FlightResponseDto flightResponseDto) {
        return null;
    }
}
