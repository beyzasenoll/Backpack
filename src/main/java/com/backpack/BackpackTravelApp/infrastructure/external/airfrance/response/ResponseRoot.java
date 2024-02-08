package com.backpack.BackpackTravelApp.infrastructure.external.airfrance.response;

import com.backpack.BackpackTravelApp.infrastructure.external.airfrance.response.fragment.airfrance.Connection__1;
import com.backpack.BackpackTravelApp.infrastructure.external.airfrance.response.fragment.airfrance.Disclaimer;
import com.backpack.BackpackTravelApp.infrastructure.external.airfrance.response.fragment.airfrance.Links__1;
import com.backpack.BackpackTravelApp.infrastructure.external.airfrance.response.fragment.airfrance.Recommendation;

import java.util.List;


public class ResponseRoot {

    public List<Recommendation> recommendations;
    public List<List<Connection__1>> connections;
    public Disclaimer disclaimer;
    public Links__1 links;

}
