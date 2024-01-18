package com.backpack.BackpackTravelApp.dto;

import lombok.Data;
import java.util.List;

@Data
public class FlightRequestDto {
    public String departureDate;
    public String arrivalDate;
    public String departureCity;
    public List<String> citiesToVisit;


}
