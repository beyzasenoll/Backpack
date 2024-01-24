package com.backpack.BackpackTravelApp.handler;

import com.backpack.BackpackTravelApp.dto.FlightRequestDto;
import com.backpack.BackpackTravelApp.dto.FlightResponseDto;
import com.backpack.BackpackTravelApp.infrastructure.external.airfrance.airFranceClient_2.AirFranceApiConnector;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class FindCheapestWayHandler {

    private String airPlaneService;
    @Autowired
    private AirFranceApiConnector airFranceApiConnector;

    public List<String> findCheapestWay(FlightResponseDto flightResponseDto) {

        return null;
    }
    
    public FlightResponseDto findMinimumPrice(FlightRequestDto getFlightRequestDto) {
            FlightResponseDto flightResponseDto = airFranceApiConnector.findMinimumPriceFromAirFranceApi(getFlightRequestDto, new FlightResponseDto());
            return new ResponseEntity<>(flightResponseDto, HttpStatus.OK).getBody();
    }
}
