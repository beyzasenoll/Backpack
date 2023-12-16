package com.backpack.BackpackTravelApp.model.airFranceModel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
public
class DateInterval {
    private Object toDate;
    //private String fromDate;
}
