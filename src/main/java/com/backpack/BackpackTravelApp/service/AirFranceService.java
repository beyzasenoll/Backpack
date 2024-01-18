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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AirFranceService {

    //TODO add test
    Logger logger = LoggerFactory.getLogger(AirFranceService.class);
    private final AirFranceApiConnector airFranceApiConnector;
    private final AirFranceResponseMapper airFranceResponseMapper;

    @Autowired
    public AirFranceService(AirFranceApiConnector airFranceApiConnector, AirFranceResponseMapper airFranceResponseMapper) {
        this.airFranceApiConnector = airFranceApiConnector;
        this.airFranceResponseMapper = airFranceResponseMapper;
    }

    public FlightDetailResponseDto findMinimumPriceFromAirFranceApi(FlightDetailRequestDto getFlightDetailRequestDto, FlightDetailResponseDto flightDetailResponseDto) {
        logger.info("Fetching total price from Air France API...");

        AirFranceFlightResponse airFranceApiResponse = airFranceApiConnector.getAirFranceFlightDetails(getFlightDetailRequestDto);

        logger.info("Air France API response received successfully.");


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
                 logger.info("Minimum price details calculated successfully.");

        return flightDetailResponseDto;
            }
        }
