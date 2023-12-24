package com.backpack.BackpackTravelApp.dto.thy;

import lombok.Getter;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class RequestHeader {

    public String clientUsername;
    public String clientTransactionId;
    public List<ExtraParameter> extraParameters;
    @Getter
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
