package com.backpack.BackpackTravelApp.infrastructure.external.airfrance.airFrance.request;

import com.backpack.BackpackTravelApp.infrastructure.external.airfrance.airFrance.request.fragment.Passenger;
import com.backpack.BackpackTravelApp.infrastructure.external.airfrance.airFrance.request.fragment.RequestedConnection;
import lombok.Data;

import java.util.ArrayList;
@Data
public class RequestRoot {
    public String type;
    public String bookingFlow;
    public ArrayList<String> commercialCabins;
    public ArrayList<Passenger> passengers;
    public ArrayList<RequestedConnection> requestedConnections;
}
