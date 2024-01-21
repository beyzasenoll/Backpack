package com.backpack.BackpackTravelApp.infrastructure.external.airfrance.airFranceClient_2.response.fragment;
import java.util.ArrayList;

public class Price{
    public double displayPrice;
    public double adjustedDisplayPrice; //for connection prices
    public double totalPrice;
    public ArrayList<PricePerPassengerType> pricePerPassengerTypes;
    public boolean flexibilityWaiver;
    public String currency;
    public String displayType;

}
