package com.backpack.BackpackTravelApp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class AirFranceFlightDetail {
    public String departureCity;
    public String destinationCity;
    public String fromDate;
    public String untilDate;
    public double totalPrice;
}
