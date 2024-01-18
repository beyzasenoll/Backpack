package com.backpack.BackpackTravelApp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class FlightResponseDto {
    public String departureDate;
    public String arrivalDate;
    public String departureCity;
    public List<String> citiesToVisit;
    public double totalPrice;
}
