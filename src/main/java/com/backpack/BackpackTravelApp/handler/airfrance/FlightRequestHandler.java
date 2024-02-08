package com.backpack.BackpackTravelApp.handler.airfrance;
import com.backpack.BackpackTravelApp.dto.FlightRequestDto;
import com.backpack.BackpackTravelApp.infrastructure.external.airfrance.request.RequestRoot;
import com.backpack.BackpackTravelApp.infrastructure.external.airfrance.request.fragment.Destination;
import com.backpack.BackpackTravelApp.infrastructure.external.airfrance.request.fragment.Origin;
import com.backpack.BackpackTravelApp.infrastructure.external.airfrance.request.fragment.Passenger;
import com.backpack.BackpackTravelApp.infrastructure.external.airfrance.request.fragment.RequestedConnection;
import com.backpack.BackpackTravelApp.mapper.airfrance.airFrance.AirFranceRequestMapper;

import java.util.ArrayList;
import java.util.List;

public class FlightRequestHandler {

    public List<RequestRoot> generateRequestedConnections(FlightRequestDto flightRequest) {
        AirFranceRequestMapper airFranceRequestMapper=new AirFranceRequestMapper();
        List<RequestRoot> requestedConnections = new ArrayList<>();
        String dateInterval=flightRequest.departureDate + "/" + flightRequest.returnDate;
        int numberOfPassengers=flightRequest.numberOfPassengers;

        String[] citiesToVisit = flightRequest.citiesToVisit.toArray(new String[0]);
        int numOfCities = citiesToVisit.length;

        for (String city : citiesToVisit) {
            requestedConnections.add(airFranceRequestMapper.mapAirFranceFlightRequest(numberOfPassengers,dateInterval,flightRequest.departureCity, city, flightRequest.minDaysOfStay, flightRequest.maxDaysOfStay));
            requestedConnections.add(airFranceRequestMapper.mapAirFranceFlightRequest(numberOfPassengers,dateInterval,city,flightRequest.departureCity,flightRequest.minDaysOfStay, flightRequest.maxDaysOfStay));

        }

        for (int i = 0; i < numOfCities - 1; i++) {
            for (int j = i + 1; j < numOfCities; j++) {
                requestedConnections.add(airFranceRequestMapper.mapAirFranceFlightRequest(numberOfPassengers,dateInterval,citiesToVisit[i], citiesToVisit[j], flightRequest.minDaysOfStay, flightRequest.maxDaysOfStay));
                requestedConnections.add(airFranceRequestMapper.mapAirFranceFlightRequest(numberOfPassengers,dateInterval,citiesToVisit[j], citiesToVisit[i], flightRequest.minDaysOfStay, flightRequest.maxDaysOfStay));
            }
        }

        return requestedConnections;
    }

}
