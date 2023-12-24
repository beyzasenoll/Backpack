package com.backpack.BackpackTravelApp.dto.thy;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class OriginDestinationInformation {

    public DepartureDateTime departureDateTime;
    public OriginLocation originLocation;
    public DestinationLocation destinationLocation;
    public FlightTypePref flightTypePref;
    public List<CabinPreference> cabinPreferences;
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
