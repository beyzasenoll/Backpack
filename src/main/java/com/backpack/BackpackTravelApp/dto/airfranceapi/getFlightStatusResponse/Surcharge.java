package com.backpack.BackpackTravelApp.dto.airfranceapi.getFlightStatusResponse;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Surcharge {
    private String code;
    private double amount;
}
