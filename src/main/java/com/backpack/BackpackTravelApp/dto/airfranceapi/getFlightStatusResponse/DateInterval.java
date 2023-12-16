package com.backpack.BackpackTravelApp.dto.airfranceapi.getFlightStatusResponse;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
public
class DateInterval {
    private String toDate; //object
    private String fromDate;
}
