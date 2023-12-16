package com.backpack.BackpackTravelApp.dto.airfranceapi.getFlightStatusRequest;

import lombok.Data;

import java.util.List;

@Data
public class GetFlightStatusRequest {
    private String bookingFlow;
    private Origin origin;
    private List<String> destinationCities;
    private String type;
    private String fromDate;
    private String untilDate;
}
