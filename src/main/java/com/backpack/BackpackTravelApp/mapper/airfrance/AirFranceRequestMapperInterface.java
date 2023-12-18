package com.backpack.BackpackTravelApp.mapper.airfrance;

import com.backpack.BackpackTravelApp.dto.FlightDetailRequestDto;
import com.backpack.BackpackTravelApp.infrastructure.external.airfrance.request.AirFranceFlightRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface AirFranceRequestMapperInterface {

    @Mapping(source = "departureCity", target = "origin.code")
    AirFranceFlightRequest toAirFranceFlightRequest(FlightDetailRequestDto request);

    @Mapping(source = "origin.code", target = "departureCity")
    FlightDetailRequestDto toGetFlightDetailRequestDto(AirFranceFlightRequest request);

}