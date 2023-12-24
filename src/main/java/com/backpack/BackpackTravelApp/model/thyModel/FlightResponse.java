package com.backpack.BackpackTravelApp.model.thyModel;

import com.backpack.BackpackTravelApp.dto.thy.DestinationLocation;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.print.attribute.standard.Destination;
import java.util.List;

@Data
@NoArgsConstructor
public class FlightResponse {
    private String origin;
    private List<DestinationLocation> destinationCities;
}
