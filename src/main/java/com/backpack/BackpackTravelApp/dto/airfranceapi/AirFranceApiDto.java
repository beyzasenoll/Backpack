package com.backpack.BackpackTravelApp.dto.airfranceapi;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class AirFranceApiDto {
    public String departureCity;
    public String destinationCity;
    public String fromDate;
    public String untilDate;
    public double totalPrice;
}
