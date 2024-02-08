package com.backpack.BackpackTravelApp.mapper.airfrance.airFrance;

import com.backpack.BackpackTravelApp.infrastructure.external.airfrance.request.RequestRoot;
import com.backpack.BackpackTravelApp.infrastructure.external.airfrance.request.fragment.Destination;
import com.backpack.BackpackTravelApp.infrastructure.external.airfrance.request.fragment.Origin;
import com.backpack.BackpackTravelApp.infrastructure.external.airfrance.request.fragment.Passenger;
import com.backpack.BackpackTravelApp.infrastructure.external.airfrance.request.fragment.RequestedConnection;

import java.util.ArrayList;

public class AirFranceRequestMapper {
    public RequestRoot mapAirFranceFlightRequest(int numberOfPassengers, String dateInterval, String originCity, String destinationCity, int minDaysOfStay, int maxDaysOfStay) {
        RequestRoot requestRoot = new RequestRoot();
        requestRoot.type = "DAY";
        requestRoot.bookingFlow = "LEISURE";
        requestRoot.requestedConnections = new ArrayList<>();
        requestRoot.commercialCabins = new ArrayList<>();

        requestRoot.passengers = new ArrayList<>();
        for (int i = 0; i < numberOfPassengers; i++) {
            Passenger passenger = new Passenger();
            passenger.id = i + 1;
            passenger.type = "ADT";
            passenger.birthDate="1980-10-10";
            requestRoot.passengers.add(passenger);
            requestRoot.commercialCabins.add("ECONOMY");
        }

        RequestedConnection connection = new RequestedConnection();
        Origin origin = new Origin(originCity);
        Destination destination = new Destination(destinationCity);

        connection.origin = origin;
        connection.destination = destination;
        connection.minDaysOfStay = minDaysOfStay;
        connection.maxDaysOfStay = maxDaysOfStay;
        connection.dateInterval = dateInterval;

        requestRoot.requestedConnections.add(connection);
        return requestRoot;
    }
}
