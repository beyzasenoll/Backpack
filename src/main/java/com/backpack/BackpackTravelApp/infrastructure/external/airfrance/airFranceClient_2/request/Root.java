package com.backpack.BackpackTravelApp.infrastructure.external.airfrance.airFranceClient_2.request;

import com.backpack.BackpackTravelApp.infrastructure.external.airfrance.airFranceClient_2.request.fragment.Passenger;
import com.backpack.BackpackTravelApp.infrastructure.external.airfrance.airFranceClient_2.request.fragment.RequestedConnection;

import java.util.ArrayList;

public class Root{
    public String type;
    public String bookingFlow;
    public ArrayList<String> commercialCabins;
    public ArrayList<Passenger> passengers;
    public ArrayList<RequestedConnection> requestedConnections;
}
