package com.backpack.BackpackTravelApp.response.fragment;

public class FLOW_SIGNATURE {
    private String INITIAL_PRODUCT;
    private String TRANSACTION;
    private String BOOKING_TYPE;


    // Getter Methods

    public String getINITIAL_PRODUCT() {
        return INITIAL_PRODUCT;
    }

    public String getTRANSACTION() {
        return TRANSACTION;
    }

    public String getBOOKING_TYPE() {
        return BOOKING_TYPE;
    }

    // Setter Methods

    public void setINITIAL_PRODUCT(String INITIAL_PRODUCT) {
        this.INITIAL_PRODUCT = INITIAL_PRODUCT;
    }

    public void setTRANSACTION(String TRANSACTION) {
        this.TRANSACTION = TRANSACTION;
    }

    public void setBOOKING_TYPE(String BOOKING_TYPE) {
        this.BOOKING_TYPE = BOOKING_TYPE;
    }
}
