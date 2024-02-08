package com.backpack.BackpackTravelApp.model.airfrance.AirFrance;

import com.backpack.BackpackTravelApp.infrastructure.external.airfrance.response.ResponseRoot;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MultipleAirfranceResponse {
    List<ResponseRoot> responseRootList;
}
