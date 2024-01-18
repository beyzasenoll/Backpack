package com.backpack.BackpackTravelApp.mapper.airfrance;

import com.backpack.BackpackTravelApp.dto.FlightResponseDto;
import com.backpack.BackpackTravelApp.model.AirFranceFlightDetail;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;

@Component
public class AirFranceResponseMapper {
    public static AirFranceFlightDetail mapAirFranceFlightResponse(FlightResponseDto flightResponseDto) {
        AirFranceFlightDetail airFranceFlightDetailResponse = new AirFranceFlightDetail();
        airFranceFlightDetailResponse.setDepartureCity(flightResponseDto.departureCity);
        airFranceFlightDetailResponse.setDepartureCity(String.valueOf(flightResponseDto.citiesToVisit));
        airFranceFlightDetailResponse.setFromDate(flightResponseDto.arrivalDate);
        airFranceFlightDetailResponse.setUntilDate(flightResponseDto.departureDate);

        return airFranceFlightDetailResponse;
    }

    public static FlightResponseDto mapFlightDetailResponseDto(AirFranceFlightDetail airFranceFlightDetail) {
        FlightResponseDto flightResponseDto = new FlightResponseDto();
        flightResponseDto.setDepartureCity(airFranceFlightDetail.departureCity);
        flightResponseDto.setCitiesToVisit(Collections.singletonList(airFranceFlightDetail.destinationCity));
        flightResponseDto.setArrivalDate(airFranceFlightDetail.fromDate);
        flightResponseDto.setDepartureDate(airFranceFlightDetail.untilDate);
        return flightResponseDto;
    }
}
