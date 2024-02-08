package com.backpack.BackpackTravelApp.dto;

import lombok.Data;
import java.util.List;

@Data
public class FlightRequestDto {
    public String departureDate;
    public String returnDate;
    public String departureCity;
    public List<String> citiesToVisit;
    public int minDaysOfStay;
    public int maxDaysOfStay;
    public int numberOfPassengers;


}
