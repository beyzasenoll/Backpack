package com.backpack.BackpackTravelApp.service;

import com.backpack.BackpackTravelApp.dto.FlightDetailRequestDto;
import com.backpack.BackpackTravelApp.dto.FlightDetailResponseDto;
import com.backpack.BackpackTravelApp.infrastructure.external.airfrance.AirFranceApiConnector;
import com.backpack.BackpackTravelApp.infrastructure.external.airfrance.response.fragment.airfrance.DestinationCity;
import com.backpack.BackpackTravelApp.infrastructure.external.airfrance.response.fragment.airfrance.FlightProduct;
import com.backpack.BackpackTravelApp.infrastructure.external.airfrance.response.AirFranceFlightResponse;
import com.backpack.BackpackTravelApp.mapper.airfrance.AirFranceResponseMapper;
import com.backpack.BackpackTravelApp.model.AirFranceFlightDetail;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;


@Service
public class AirFranceService {

    //TODO add test
    Logger logger = LoggerFactory.getLogger(AirFranceService.class);

    public FlightDetailResponseDto findMinimumPriceFromAirFranceApi(FlightDetailRequestDto getFlightDetailRequestDto, FlightDetailResponseDto flightDetailResponseDto) {
        logger.info("Fetching total price from Air France API...");

                AirFranceApiConnector airFranceApiConnector =new AirFranceApiConnector();
                AirFranceFlightResponse airFranceApiResponse = airFranceApiConnector.getAirFranceFlightDetails(getFlightDetailRequestDto);
                AirFranceResponseMapper airFranceResponseMapper= new AirFranceResponseMapper();


                //burada air france rest connector çağıracaksın.
                //Air france rest client'ı çağırmak için öncelikle airFrance request'ini maplemen gerekiyor.
                //Air france rest client output'u GetAirFranceFlightResponse bu olacak.
                // sen ekstra rest'e dair bir obje burada barındırmayacaksın.
                String originCode = airFranceApiResponse.getOrigin();
                double minTotalPrice = Double.MAX_VALUE;
                String minTotalPriceCity = null;
                String departureDate = null;
                String returnDate = null;

                //TODO: for yerine stream kullan.
                for (DestinationCity destinationCity : airFranceApiResponse.getDestinationCities()) {
                    for (FlightProduct flightProduct : destinationCity.getFlightProducts()) {
                        double currentTotalPrice = flightProduct.getPrice().getTotalPrice();
                        if (currentTotalPrice < minTotalPrice) {
                            minTotalPrice = currentTotalPrice;
                            minTotalPriceCity = destinationCity.getName();
                            departureDate = flightProduct.getDepartureDate();
                            returnDate = flightProduct.getReturnDate();
                        }
                    }
                }
                AirFranceFlightDetail airFranceFlightDetail= new AirFranceFlightDetail(originCode, minTotalPriceCity, departureDate, returnDate, minTotalPrice);
                flightDetailResponseDto = airFranceResponseMapper.mapFlightDetailResponseDto(airFranceFlightDetail);
                return flightDetailResponseDto;
            }
        }
