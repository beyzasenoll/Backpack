package com.backpack.BackpackTravelApp.infrastructure.external.airfrance.request.fragment;

public class RequestedConnection{
    /*public String departureDate;
    public String arrivalDate;
    public String departureCity;
    public List<String> citiesToVisit;
    public int minDaysOfStay;
    public int maxDaysOfStay;*/
    public String dateInterval; //departureDate/returnDate 2024-10-10/2024-10-13
    public Integer minDaysOfStay; //minDaysOfStay
    public Integer maxDaysOfStay; //maxDaysOfStay
    public Origin origin;
    public Destination destination;
}
