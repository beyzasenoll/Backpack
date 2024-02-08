package com.backpack.BackpackTravelApp.infrastructure.external.airfrance.response.fragment.airfrance;

import lombok.Data;

import java.util.List;

@Data
public class Connection {

    public Integer connectionId;
    public Integer numberOfSeatsAvailable;
    public List<Segment> segments;
    public String commercialCabin;
    public String commercialCabinLabel;
    public Price__1 price;
    public Links links;

}
