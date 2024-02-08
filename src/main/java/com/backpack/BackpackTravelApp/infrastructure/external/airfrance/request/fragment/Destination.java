package com.backpack.BackpackTravelApp.infrastructure.external.airfrance.request.fragment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Destination{
    public String code;
    public String type;


    public Destination(String destinationCity) {
        this.code=destinationCity;
        this.type="CITY";

    }
}
