package com.backpack.BackpackTravelApp.service.airfrance;

import com.backpack.BackpackTravelApp.dto.FlightRequestDto;
import com.backpack.BackpackTravelApp.infrastructure.external.airfrance.AirFranceApiConnector;
import com.backpack.BackpackTravelApp.infrastructure.external.airfrance.request.RequestRoot;
import com.backpack.BackpackTravelApp.infrastructure.external.airfrance.response.ResponseRoot;
import com.backpack.BackpackTravelApp.infrastructure.external.airfrance.response.fragment.airfrance.*;
import com.backpack.BackpackTravelApp.model.airfrance.AirFrance.AirFranceFlightDetail;
import com.backpack.BackpackTravelApp.model.airfrance.AirFrance.AirfranceResponseModelDetail;
import com.backpack.BackpackTravelApp.model.airfrance.AirFrance.MultipleAirfranceResponse;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class AirFranceService {
    public List<AirfranceResponseModelDetail> matchFlightProducts(FlightRequestDto flightRequestDto) {
        AirFranceApiConnector airFranceApiConnector=new AirFranceApiConnector();
        ResponseRoot responseRootList =airFranceApiConnector.getAirFranceFlightsInformation(flightRequestDto);

        recommendationData =  responseRootList.recommendations.stream().forEach(
                x -> x.flightProducts.stream().forEach(y -> )
        );

        connectionData = responseRootList.connections.stream().forEach(
                x -> x.stream().filter(y -> y.id == recommendationData.id)
        );

        Set<Integer> connectionIDs = responseRootList.stream()
                .flatMap(root -> root.recommendations.stream())
                .flatMap(recommendation -> recommendation.flightProducts.stream())
                .flatMap(flightProduct -> flightProduct.connections.stream())
                .peek(connection -> {
                    double totalPrice = connection.price.displayPrice;
                })
                .map(connection -> connection.connectionId)
                .collect(Collectors.toSet());

            Map<Integer, Connection__1> connectionMap = responseRootList.stream()
                .flatMap(root -> root.connections.stream()
                        .flatMap(List::stream))
                .filter(connection -> connectionIDs.contains(connection.id))
                .collect(Collectors.toMap(connection -> connection.id, connection -> connection));

            connectionMap.forEach((id, connection) -> {
            String departureDate = connection.departureDate;
            String departureCity = connection.origin.city.name;
            String destinationCity = connection.destination.city.name;
        });
        return null;
    }
}
