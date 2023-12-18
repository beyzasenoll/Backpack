package com.backpack.BackpackTravelApp.mapper.airfrance;

import com.backpack.BackpackTravelApp.dto.FlightDetailRequestDto;
import com.backpack.BackpackTravelApp.infrastructure.external.airfrance.request.AirFranceFlightRequest;

public class AirFranceRequestMapper {
    public static AirFranceFlightRequest mapToGetAirFranceFlightRequest(FlightDetailRequestDto flightDetailRequestDto){
        AirFranceFlightRequest airFranceFlightRequest =new AirFranceFlightRequest();
        airFranceFlightRequest.getOrigin().setCode(flightDetailRequestDto.departureCity);
        airFranceFlightRequest.setDestinationCities(flightDetailRequestDto.getDestinationCities());
        airFranceFlightRequest.setFromDate(flightDetailRequestDto.fromDate);
        airFranceFlightRequest.setUntilDate(flightDetailRequestDto.untilDate);

        return airFranceFlightRequest;
    }

    public static FlightDetailRequestDto getFlightDetailRequestDto(AirFranceFlightRequest airFranceFlightRequest){
        FlightDetailRequestDto flightDetailRequestDto =new FlightDetailRequestDto();
        flightDetailRequestDto.setDepartureCity(airFranceFlightRequest.getOrigin().getCode());
        flightDetailRequestDto.setDestinationCities(airFranceFlightRequest.getDestinationCities());
        flightDetailRequestDto.setFromDate(airFranceFlightRequest.getFromDate());
        flightDetailRequestDto.setUntilDate(airFranceFlightRequest.getUntilDate());
        return flightDetailRequestDto;
    }
}