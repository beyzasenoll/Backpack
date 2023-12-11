package com.backpack.BackpackTravelApp.model.airFranceModel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Surcharge {
    private String code;
    private double amount;
}
