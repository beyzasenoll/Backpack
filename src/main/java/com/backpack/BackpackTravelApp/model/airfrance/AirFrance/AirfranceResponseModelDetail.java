package com.backpack.BackpackTravelApp.model.airfrance.AirFrance;

import lombok.Data;

@Data
public class AirfranceResponseModelDetail {
    private double totalprice;
    public String currency;
    public String departureDate;
    public String departureCity;
    public String destinationCity;
}
