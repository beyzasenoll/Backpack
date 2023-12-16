package com.backpack.BackpackTravelApp.model.airFranceModel;

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
