package com.backpack.BackpackTravelApp.dto.thy;

import java.util.LinkedHashMap;
import java.util.Map;

public class DepartureDateTime {

    public String windowAfter;
    public String windowBefore;
    public String date;
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
