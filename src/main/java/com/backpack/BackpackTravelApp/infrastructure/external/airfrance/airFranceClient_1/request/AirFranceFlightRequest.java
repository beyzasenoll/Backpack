package com.backpack.BackpackTravelApp.infrastructure.external.airfrance.airFranceClient_1.request;

import com.backpack.BackpackTravelApp.infrastructure.external.airfrance.airFranceClient_1.request.fragment.airfrance.Origin;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class AirFranceFlightRequest {
    //private String bookingFlow = null;
    private Origin origin;
    private List<String> destinationCities;
    //private String type=null;
    private String fromDate;
    private String untilDate;

    public AirFranceFlightRequest(Origin origin, List<String> destinationCities, String fromDate, String untilDate) {
        this.origin = origin;
        this.destinationCities = destinationCities;
        this.fromDate = fromDate;
        this.untilDate = untilDate;
    }
}
