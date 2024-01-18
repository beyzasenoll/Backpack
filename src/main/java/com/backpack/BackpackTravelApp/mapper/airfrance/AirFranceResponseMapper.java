package com.backpack.BackpackTravelApp.mapper.airfrance;

import com.backpack.BackpackTravelApp.dto.FlightDetailResponseDto;
import com.backpack.BackpackTravelApp.model.AirFranceFlightDetail;
import org.springframework.stereotype.Component;

@Component
public class AirFranceResponseMapper {
    public static AirFranceFlightDetail mapAirFranceFlightResponse(FlightDetailResponseDto flightDetailResponseDto) {
        AirFranceFlightDetail airFranceFlightDetailResponse = new AirFranceFlightDetail();
        airFranceFlightDetailResponse.setDepartureCity(flightDetailResponseDto.departureCity);
        airFranceFlightDetailResponse.setDepartureCity(flightDetailResponseDto.destinationCity);
        airFranceFlightDetailResponse.setFromDate(flightDetailResponseDto.fromDate);
        airFranceFlightDetailResponse.setUntilDate(flightDetailResponseDto.untilDate);

        return airFranceFlightDetailResponse;
    }

    public static FlightDetailResponseDto mapFlightDetailResponseDto(AirFranceFlightDetail airFranceFlightDetail) {
        FlightDetailResponseDto flightDetailResponseDto = new FlightDetailResponseDto();
        flightDetailResponseDto.setDepartureCity(airFranceFlightDetail.departureCity);
        flightDetailResponseDto.setDestinationCity(airFranceFlightDetail.destinationCity);
        flightDetailResponseDto.setFromDate(airFranceFlightDetail.fromDate);
        flightDetailResponseDto.setUntilDate(airFranceFlightDetail.untilDate);
        return flightDetailResponseDto;
    }
}
