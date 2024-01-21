package com.backpack.BackpackTravelApp.infrastructure.external.airfrance.airFranceClient_2.response;
import com.backpack.BackpackTravelApp.infrastructure.external.airfrance.airFranceClient_2.response.fragment.Connection;
import com.backpack.BackpackTravelApp.infrastructure.external.airfrance.airFranceClient_2.response.fragment.Disclaimer;
import com.backpack.BackpackTravelApp.infrastructure.external.airfrance.airFranceClient_2.response.fragment.Links;
import com.backpack.BackpackTravelApp.infrastructure.external.airfrance.airFranceClient_2.response.fragment.Recommendation;

import java.util.ArrayList;

public class Root{
    public ArrayList<Recommendation> recommendations;
    public ArrayList<Connection> connections;
    public Disclaimer disclaimer;
    public Links _links;
}
