package com.backpack.BackpackTravelApp.response.fragment;

public class LIST_SERVICE_FEE_INFO_GROUP {
    ITEM_NUMBER_INFO ITEM_NUMBER_INFOObject;
    SERVICE_DETAILS_GROUP SERVICE_DETAILS_GROUPObject;


    // Getter Methods

    public ITEM_NUMBER_INFO getITEM_NUMBER_INFO() {
        return ITEM_NUMBER_INFOObject;
    }

    public SERVICE_DETAILS_GROUP getSERVICE_DETAILS_GROUP() {
        return SERVICE_DETAILS_GROUPObject;
    }

    // Setter Methods

    public void setITEM_NUMBER_INFO(ITEM_NUMBER_INFO ITEM_NUMBER_INFOObject) {
        this.ITEM_NUMBER_INFOObject = ITEM_NUMBER_INFOObject;
    }

    public void setSERVICE_DETAILS_GROUP(SERVICE_DETAILS_GROUP SERVICE_DETAILS_GROUPObject) {
        this.SERVICE_DETAILS_GROUPObject = SERVICE_DETAILS_GROUPObject;
    }
}
