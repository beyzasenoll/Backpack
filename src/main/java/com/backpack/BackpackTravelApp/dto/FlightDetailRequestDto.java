package com.backpack.BackpackTravelApp.dto;

import lombok.Data;
import java.util.List;

@Data
public class FlightDetailRequestDto {
    public String departureCity;
    public List<String> destinationCities;
    public String fromDate;
    public String untilDate;
}
