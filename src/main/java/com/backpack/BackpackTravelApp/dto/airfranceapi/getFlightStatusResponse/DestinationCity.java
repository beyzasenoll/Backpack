package com.backpack.BackpackTravelApp.dto.airfranceapi.getFlightStatusResponse;

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
