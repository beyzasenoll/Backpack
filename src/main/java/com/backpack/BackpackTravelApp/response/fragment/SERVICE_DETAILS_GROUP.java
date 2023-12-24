package com.backpack.BackpackTravelApp.response.fragment;

public class SERVICE_DETAILS_GROUP {
    REF_INFO REF_INFOObject;
    SERVICE_MATCHED_INFO_GROUP SERVICE_MATCHED_INFO_GROUPObject;


    // Getter Methods

    public REF_INFO getREF_INFO() {
        return REF_INFOObject;
    }

    public SERVICE_MATCHED_INFO_GROUP getSERVICE_MATCHED_INFO_GROUP() {
        return SERVICE_MATCHED_INFO_GROUPObject;
    }

    // Setter Methods

    public void setREF_INFO(REF_INFO REF_INFOObject) {
        this.REF_INFOObject = REF_INFOObject;
    }

    public void setSERVICE_MATCHED_INFO_GROUP(SERVICE_MATCHED_INFO_GROUP SERVICE_MATCHED_INFO_GROUPObject) {
        this.SERVICE_MATCHED_INFO_GROUPObject = SERVICE_MATCHED_INFO_GROUPObject;
    }
}
