package com.backpack.BackpackTravelApp.model.airfrance.AirFrance;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


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
