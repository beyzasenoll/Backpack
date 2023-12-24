package com.backpack.BackpackTravelApp.response.fragment;

public class FlexPricerAvailabilityOutput {
    LIST_AVAILABILITY_RANGE LIST_AVAILABILITY_RANGEObject;
    private String jSessionId;
    LIST_PANEL LIST_PANELObject;
    LIST_SERVICE_FEES_GROUP LIST_SERVICE_FEES_GROUPObject;
    private String PAGE_TICKET;
    private String TEMPLATE;
    FLOW_SIGNATURE FLOW_SIGNATUREObject;
    FARE_FAMILY_DICTIONARY FARE_FAMILY_DICTIONARYObject;


    // Getter Methods

    public LIST_AVAILABILITY_RANGE getLIST_AVAILABILITY_RANGE() {
        return LIST_AVAILABILITY_RANGEObject;
    }

    public String getJSessionId() {
        return jSessionId;
    }

    public LIST_PANEL getLIST_PANEL() {
        return LIST_PANELObject;
    }

    public LIST_SERVICE_FEES_GROUP getLIST_SERVICE_FEES_GROUP() {
        return LIST_SERVICE_FEES_GROUPObject;
    }

    public String getPAGE_TICKET() {
        return PAGE_TICKET;
    }

    public String getTEMPLATE() {
        return TEMPLATE;
    }

    public FLOW_SIGNATURE getFLOW_SIGNATURE() {
        return FLOW_SIGNATUREObject;
    }

    public FARE_FAMILY_DICTIONARY getFARE_FAMILY_DICTIONARY() {
        return FARE_FAMILY_DICTIONARYObject;
    }

    // Setter Methods

    public void setLIST_AVAILABILITY_RANGE(LIST_AVAILABILITY_RANGE LIST_AVAILABILITY_RANGEObject) {
        this.LIST_AVAILABILITY_RANGEObject = LIST_AVAILABILITY_RANGEObject;
    }

    public void setJSessionId(String jSessionId) {
        this.jSessionId = jSessionId;
    }

    public void setLIST_PANEL(LIST_PANEL LIST_PANELObject) {
        this.LIST_PANELObject = LIST_PANELObject;
    }

    public void setLIST_SERVICE_FEES_GROUP(LIST_SERVICE_FEES_GROUP LIST_SERVICE_FEES_GROUPObject) {
        this.LIST_SERVICE_FEES_GROUPObject = LIST_SERVICE_FEES_GROUPObject;
    }

    public void setPAGE_TICKET(String PAGE_TICKET) {
        this.PAGE_TICKET = PAGE_TICKET;
    }

    public void setTEMPLATE(String TEMPLATE) {
        this.TEMPLATE = TEMPLATE;
    }

    public void setFLOW_SIGNATURE(FLOW_SIGNATURE FLOW_SIGNATUREObject) {
        this.FLOW_SIGNATUREObject = FLOW_SIGNATUREObject;
    }

    public void setFARE_FAMILY_DICTIONARY(FARE_FAMILY_DICTIONARY FARE_FAMILY_DICTIONARYObject) {
        this.FARE_FAMILY_DICTIONARYObject = FARE_FAMILY_DICTIONARYObject;
    }
}
