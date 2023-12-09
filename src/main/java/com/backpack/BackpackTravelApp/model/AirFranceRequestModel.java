package com.backpack.BackpackTravelApp.model;

import lombok.Data;
import org.springframework.boot.origin.Origin;

import java.util.List;
@Data
public class AirFranceRequestModel {
    private String bookingFlow;
    private Origin origin;
    private List<String> destinationCities;
    private String type;
    private String fromDate;
    private String untilDate;
}
