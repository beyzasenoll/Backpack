package com.backpack.BackpackTravelApp.infrastructure.external.airfrance.airFrance.response;
import com.backpack.BackpackTravelApp.infrastructure.external.airfrance.airFrance.response.fragment.Connection;
import com.backpack.BackpackTravelApp.infrastructure.external.airfrance.airFrance.response.fragment.Disclaimer;
import com.backpack.BackpackTravelApp.infrastructure.external.airfrance.airFrance.response.fragment.Links;
import com.backpack.BackpackTravelApp.infrastructure.external.airfrance.airFrance.response.fragment.Recommendation;

import java.util.ArrayList;

public class ResponseRoot {
    public ArrayList<Recommendation> recommendations;
    public ArrayList<Connection> connections;
    public Disclaimer disclaimer;
    public Links _links;
}
