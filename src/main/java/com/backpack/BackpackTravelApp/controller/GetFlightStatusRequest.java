package com.backpack.BackpackTravelApp.controller;

import lombok.Data;

import java.util.List;

@Data
public class GetFlightStatusRequest {
     String bookingFlow; // default'u ney public mi private mi ?
     Origin origin;
     List<String> destinationCities;
}
