package com.backpack.BackpackTravelApp.mapper.airfrance;

import com.backpack.BackpackTravelApp.dto.FlightRequestDto;
import com.backpack.BackpackTravelApp.infrastructure.external.airfrance.request.AirFranceFlightRequest;
import com.backpack.BackpackTravelApp.infrastructure.external.airfrance.request.fragment.airfrance.Origin;
import org.springframework.stereotype.Component;

@Component
public class AirFranceRequestMapper {
    public static AirFranceFlightRequest mapToGetAirFranceFlightRequest(FlightRequestDto flightRequestDto) {
        AirFranceFlightRequest airFranceFlightRequest = new AirFranceFlightRequest();

        airFranceFlightRequest.setOrigin(new Origin());
        airFranceFlightRequest.getOrigin().setType("CITY");
        airFranceFlightRequest.getOrigin().setCode(flightRequestDto.departureCity);

        airFranceFlightRequest.setDestinationCities(flightRequestDto.getCitiesToVisit());
        airFranceFlightRequest.setFromDate(flightRequestDto.arrivalDate);
        airFranceFlightRequest.setUntilDate(flightRequestDto.departureDate);

        return airFranceFlightRequest;
    }


    public static FlightRequestDto getFlightDetailRequestDto(AirFranceFlightRequest airFranceFlightRequest){
        FlightRequestDto flightRequestDto =new FlightRequestDto();
        flightRequestDto.setDepartureCity(airFranceFlightRequest.getOrigin().getCode());
        flightRequestDto.setCitiesToVisit(airFranceFlightRequest.getDestinationCities());
        flightRequestDto.setArrivalDate(airFranceFlightRequest.getFromDate());
        flightRequestDto.setDepartureDate(airFranceFlightRequest.getUntilDate());
        return flightRequestDto;
    }
}