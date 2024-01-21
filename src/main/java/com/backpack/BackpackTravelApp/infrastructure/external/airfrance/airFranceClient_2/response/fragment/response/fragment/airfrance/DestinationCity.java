package com.backpack.BackpackTravelApp.infrastructure.external.airfrance.airFranceClient_2.response.fragment.response.fragment.airfrance;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class DestinationCity {
    private String name;
    private String code;
    private List<FlightProduct> flightProducts;
}
