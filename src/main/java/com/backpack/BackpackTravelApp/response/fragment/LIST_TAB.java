package com.backpack.BackpackTravelApp.response.fragment;

public class LIST_TAB {
    LIST_DATE LIST_DATEObject;
    LIST_PROPOSED_BOUND LIST_PROPOSED_BOUNDObject;
    ArrayList<Object> LIST_RECOMMENDATION = new ArrayList<Object>();


    // Getter Methods

    public LIST_DATE getLIST_DATE() {
        return LIST_DATEObject;
    }

    public LIST_PROPOSED_BOUND getLIST_PROPOSED_BOUND() {
        return LIST_PROPOSED_BOUNDObject;
    }

    // Setter Methods

    public void setLIST_DATE(LIST_DATE LIST_DATEObject) {
        this.LIST_DATEObject = LIST_DATEObject;
    }

    public void setLIST_PROPOSED_BOUND(LIST_PROPOSED_BOUND LIST_PROPOSED_BOUNDObject) {
        this.LIST_PROPOSED_BOUNDObject = LIST_PROPOSED_BOUNDObject;
    }
}
