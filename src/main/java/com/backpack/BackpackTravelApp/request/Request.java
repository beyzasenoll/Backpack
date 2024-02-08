package com.backpack.BackpackTravelApp.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Request {
    public String departureDate;
    public String departureCity;
    public int passenger_count;
}
