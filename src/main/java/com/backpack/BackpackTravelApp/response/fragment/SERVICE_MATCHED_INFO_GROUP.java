package com.backpack.BackpackTravelApp.response.fragment;

public class SERVICE_MATCHED_INFO_GROUP {
    AMOUNT_INFO AMOUNT_INFOObject;
    PAX_REF_INFO PAX_REF_INFOObject;
    PRICING_INFO PRICING_INFOObject;


    // Getter Methods

    public AMOUNT_INFO getAMOUNT_INFO() {
        return AMOUNT_INFOObject;
    }

    public PAX_REF_INFO getPAX_REF_INFO() {
        return PAX_REF_INFOObject;
    }

    public PRICING_INFO getPRICING_INFO() {
        return PRICING_INFOObject;
    }

    // Setter Methods

    public void setAMOUNT_INFO(AMOUNT_INFO AMOUNT_INFOObject) {
        this.AMOUNT_INFOObject = AMOUNT_INFOObject;
    }

    public void setPAX_REF_INFO(PAX_REF_INFO PAX_REF_INFOObject) {
        this.PAX_REF_INFOObject = PAX_REF_INFOObject;
    }

    public void setPRICING_INFO(PRICING_INFO PRICING_INFOObject) {
        this.PRICING_INFOObject = PRICING_INFOObject;
    }
}
