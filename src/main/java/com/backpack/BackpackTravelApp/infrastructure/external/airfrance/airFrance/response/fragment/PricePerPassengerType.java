package com.backpack.BackpackTravelApp.infrastructure.external.airfrance.airFrance.response.fragment;
import java.util.ArrayList;

public class PricePerPassengerType{
    public String passengerType;
    public double fare;
    public double taxes;
    public int products;
    public ArrayList<Surcharge> surcharges;
    public boolean primaryPax;
}
