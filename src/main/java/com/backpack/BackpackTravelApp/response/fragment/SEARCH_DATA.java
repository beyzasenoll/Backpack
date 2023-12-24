package com.backpack.BackpackTravelApp.response.fragment;

public class SEARCH_DATA {
    ArrayList<Object> LIST_COMMERCIAL_FARE_FAMILY = new ArrayList<Object>();
    private String TRIP_TYPE;
    LIST_DESTINATION LIST_DESTINATIONObject;
    private String PRICING_TYPE;
    private String DISPLAY_TYPE;


    // Getter Methods

    public String getTRIP_TYPE() {
        return TRIP_TYPE;
    }

    public LIST_DESTINATION getLIST_DESTINATION() {
        return LIST_DESTINATIONObject;
    }

    public String getPRICING_TYPE() {
        return PRICING_TYPE;
    }

    public String getDISPLAY_TYPE() {
        return DISPLAY_TYPE;
    }

    // Setter Methods

    public void setTRIP_TYPE(String TRIP_TYPE) {
        this.TRIP_TYPE = TRIP_TYPE;
    }

    public void setLIST_DESTINATION(LIST_DESTINATION LIST_DESTINATIONObject) {
        this.LIST_DESTINATIONObject = LIST_DESTINATIONObject;
    }

    public void setPRICING_TYPE(String PRICING_TYPE) {
        this.PRICING_TYPE = PRICING_TYPE;
    }

    public void setDISPLAY_TYPE(String DISPLAY_TYPE) {
        this.DISPLAY_TYPE = DISPLAY_TYPE;
    }
}
