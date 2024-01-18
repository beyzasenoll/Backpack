package com.backpack.BackpackTravelApp.infrastructure.external.airfrance.response;

import com.backpack.BackpackTravelApp.infrastructure.external.airfrance.response.fragment.airfrance.DestinationCity;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
public class AirFranceFlightResponse {
    private String origin;
    private List<DestinationCity> destinationCities;
}


