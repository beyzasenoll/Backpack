package com.backpack.BackpackTravelApp.response.fragment;

public class LIST_DESTINATION {
    private String B_TIME_WINDOW;
    B_DATE B_DATEObject;
    E_LOCATION E_LOCATIONObject;
    B_LOCATION B_LOCATIONObject;


    // Getter Methods

    public String getB_TIME_WINDOW() {
        return B_TIME_WINDOW;
    }

    public B_DATE getB_DATE() {
        return B_DATEObject;
    }

    public E_LOCATION getE_LOCATION() {
        return E_LOCATIONObject;
    }

    public B_LOCATION getB_LOCATION() {
        return B_LOCATIONObject;
    }

    // Setter Methods

    public void setB_TIME_WINDOW(String B_TIME_WINDOW) {
        this.B_TIME_WINDOW = B_TIME_WINDOW;
    }

    public void setB_DATE(B_DATE B_DATEObject) {
        this.B_DATEObject = B_DATEObject;
    }

    public void setE_LOCATION(E_LOCATION E_LOCATIONObject) {
        this.E_LOCATIONObject = E_LOCATIONObject;
    }

    public void setB_LOCATION(B_LOCATION B_LOCATIONObject) {
        this.B_LOCATIONObject = B_LOCATIONObject;
    }
}
