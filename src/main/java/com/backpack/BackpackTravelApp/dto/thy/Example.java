package com.backpack.BackpackTravelApp.dto.thy;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Example {

    public RequestHeader requestHeader;
    public Boolean reducedDataIndicator;
    public String routingType;
    public String targetSource;
    public List<PassengerTypeQuantity> passengerTypeQuantity;
    public List<OriginDestinationInformation> originDestinationInformation;
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
