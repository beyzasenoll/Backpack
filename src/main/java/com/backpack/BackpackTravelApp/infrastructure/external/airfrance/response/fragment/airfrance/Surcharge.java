package com.backpack.BackpackTravelApp.infrastructure.external.airfrance.response.fragment.airfrance;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Surcharge {
    private String code;
    private double amount;
}
