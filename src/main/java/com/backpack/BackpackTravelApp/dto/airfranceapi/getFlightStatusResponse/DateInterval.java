package com.backpack.BackpackTravelApp.dto.airfranceapi.getFlightStatusResponse;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public
class DateInterval {
    private String toDate;
    private String fromDate;
}
