package com.backpack.BackpackTravelApp.response.fragment;

public class LIST_AVAILABILITY_RANGE {
    private String LOCATION;
    MAX_AVAIL_DATE MAX_AVAIL_DATEObject;
    MIN_AVAIL_DATE MIN_AVAIL_DATEObject;


    // Getter Methods

    public String getLOCATION() {
        return LOCATION;
    }

    public MAX_AVAIL_DATE getMAX_AVAIL_DATE() {
        return MAX_AVAIL_DATEObject;
    }

    public MIN_AVAIL_DATE getMIN_AVAIL_DATE() {
        return MIN_AVAIL_DATEObject;
    }

    // Setter Methods

    public void setLOCATION(String LOCATION) {
        this.LOCATION = LOCATION;
    }

    public void setMAX_AVAIL_DATE(MAX_AVAIL_DATE MAX_AVAIL_DATEObject) {
        this.MAX_AVAIL_DATEObject = MAX_AVAIL_DATEObject;
    }

    public void setMIN_AVAIL_DATE(MIN_AVAIL_DATE MIN_AVAIL_DATEObject) {
        this.MIN_AVAIL_DATEObject = MIN_AVAIL_DATEObject;
    }
}
