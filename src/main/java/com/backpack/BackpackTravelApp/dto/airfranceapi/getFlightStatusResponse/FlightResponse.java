package com.backpack.BackpackTravelApp.dto.airfranceapi.getFlightStatusResponse;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
public class FlightResponse {
    private String origin;
    private List<DestinationCity> destinationCities;
}


