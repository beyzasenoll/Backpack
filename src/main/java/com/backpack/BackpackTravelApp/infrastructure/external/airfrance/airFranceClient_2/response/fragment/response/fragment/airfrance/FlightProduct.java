package com.backpack.BackpackTravelApp.infrastructure.external.airfrance.airFranceClient_2.response.fragment.response.fragment.airfrance;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FlightProduct {
    private String dateInterval;
    private String departureDate;
    private String returnDate;
    private int duration;
    private Price price;
}
