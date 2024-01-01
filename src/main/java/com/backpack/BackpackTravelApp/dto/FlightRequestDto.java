package com.backpack.BackpackTravelApp.dto;
import com.backpack.BackpackTravelApp.controller.FindCheapestWayHandler;
import lombok.Setter;

@Setter
public class FlightRequestDto { //FlightInput --> FlightInputRequestDto
    public String departureDate;
    public String arrivalDate;
    public String departureCity;
    public String cities_to_visit_1;
    public String cities_to_visit_2;
    public String cities_to_visit_3;


}