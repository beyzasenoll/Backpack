package com.backpack.BackpackTravelApp.response.fragment;

public class LIST_SERVICE_COVERAGE_INFO_GROUP {
    ITEM_NUMBER_INFO ITEM_NUMBER_INFOObject;
    SERVICE_COV_INFO_GROUP SERVICE_COV_INFO_GROUPObject;


    // Getter Methods

    public ITEM_NUMBER_INFO getITEM_NUMBER_INFO() {
        return ITEM_NUMBER_INFOObject;
    }

    public SERVICE_COV_INFO_GROUP getSERVICE_COV_INFO_GROUP() {
        return SERVICE_COV_INFO_GROUPObject;
    }

    // Setter Methods

    public void setITEM_NUMBER_INFO(ITEM_NUMBER_INFO ITEM_NUMBER_INFOObject) {
        this.ITEM_NUMBER_INFOObject = ITEM_NUMBER_INFOObject;
    }

    public void setSERVICE_COV_INFO_GROUP(SERVICE_COV_INFO_GROUP SERVICE_COV_INFO_GROUPObject) {
        this.SERVICE_COV_INFO_GROUPObject = SERVICE_COV_INFO_GROUPObject;
    }
}
