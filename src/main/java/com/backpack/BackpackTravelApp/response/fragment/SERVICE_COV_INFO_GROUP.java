package com.backpack.BackpackTravelApp.response.fragment;

public class SERVICE_COV_INFO_GROUP {
    REF_INFO REF_INFOObject;
    PAX_REF_INFO PAX_REF_INFOObject;
    COVERAGE_PER_FLIGHTS_INFO COVERAGE_PER_FLIGHTS_INFOObject;


    // Getter Methods

    public REF_INFO getREF_INFO() {
        return REF_INFOObject;
    }

    public PAX_REF_INFO getPAX_REF_INFO() {
        return PAX_REF_INFOObject;
    }

    public COVERAGE_PER_FLIGHTS_INFO getCOVERAGE_PER_FLIGHTS_INFO() {
        return COVERAGE_PER_FLIGHTS_INFOObject;
    }

    // Setter Methods

    public void setREF_INFO(REF_INFO REF_INFOObject) {
        this.REF_INFOObject = REF_INFOObject;
    }

    public void setPAX_REF_INFO(PAX_REF_INFO PAX_REF_INFOObject) {
        this.PAX_REF_INFOObject = PAX_REF_INFOObject;
    }

    public void setCOVERAGE_PER_FLIGHTS_INFO(COVERAGE_PER_FLIGHTS_INFO COVERAGE_PER_FLIGHTS_INFOObject) {
        this.COVERAGE_PER_FLIGHTS_INFOObject = COVERAGE_PER_FLIGHTS_INFOObject;
    }
}
