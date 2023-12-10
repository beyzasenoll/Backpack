package com.backpack.BackpackTravelApp.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
public class FlightInput{
    public Date departureDate;
    public String departureCity;
    public String cities_to_visit_1;
    public String cities_to_visit_2;
    public String cities_to_visit_3;


}