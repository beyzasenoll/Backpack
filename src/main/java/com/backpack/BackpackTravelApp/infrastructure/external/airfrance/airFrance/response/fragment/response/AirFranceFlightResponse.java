package com.backpack.BackpackTravelApp.infrastructure.external.airfrance.airFrance.response.fragment.response;

import com.backpack.BackpackTravelApp.infrastructure.external.airfrance.airFrance.response.fragment.response.fragment.airfrance.DestinationCity;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
public class AirFranceFlightResponse {
    private String origin;
    private List<DestinationCity> destinationCities;
}


