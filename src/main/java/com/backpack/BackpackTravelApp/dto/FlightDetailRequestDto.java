package com.backpack.BackpackTravelApp.dto;

import lombok.Data;
import java.util.List;

@Data
public class FlightDetailRequestDto {
    public String departureCity;
    public String departureCityType;
    public List<String> destinationCities;
    public String fromDate;
    public String untilDate;

}
