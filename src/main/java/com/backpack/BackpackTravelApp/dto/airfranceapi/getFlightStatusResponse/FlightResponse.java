package com.backpack.BackpackTravelApp.dto.airfranceapi.getFlightStatusResponse;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class FlightResponse {
    private String origin;
    private List<DestinationCity> destinationCities;
}


