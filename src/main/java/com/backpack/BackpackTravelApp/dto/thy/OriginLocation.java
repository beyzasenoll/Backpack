package com.backpack.BackpackTravelApp.dto.thy;

import lombok.Getter;

import java.util.LinkedHashMap;
import java.util.Map;

public class OriginLocation {

    public String locationCode;
    public Boolean multiAirportCityInd;
    @Getter
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
