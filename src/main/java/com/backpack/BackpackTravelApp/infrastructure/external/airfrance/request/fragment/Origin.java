package com.backpack.BackpackTravelApp.infrastructure.external.airfrance.request.fragment;

public class Origin{
    public String code;
    public String type;
    public Origin(String code) {
        this.code = code;
        this.type = "CITY";
    }
}