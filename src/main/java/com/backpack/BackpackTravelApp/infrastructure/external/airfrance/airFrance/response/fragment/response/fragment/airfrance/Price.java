package com.backpack.BackpackTravelApp.infrastructure.external.airfrance.airFrance.response.fragment.response.fragment.airfrance;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public
class Price {
    private double displayPrice;
    private double totalPrice;
    private List<Surcharge> surcharges;
    private int fare;
    private int taxes;
    private String currency;
    private String displayType;
}
