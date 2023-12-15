package com.backpack.BackpackTravelApp.service.ThyAPIservice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ApiExplorer {
    public static void main(String[] args) throws IOException {
        StringBuilder urlBuilder = new StringBuilder("https://api.turkishairlines.com/test/getAvailability");
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("apisecret", "2ef87fa129aa405eaf481881c2a7aeb1");
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setRequestProperty("apikey", "l7xxdb2f2877af1f4fc39f40b95f76bf4c4e");
        byte[] body = "{	\"requestHeader\": {		\"clientUsername\": \"OPENAPI\",		\"clientTransactionId\": \"CLIENT_TEST_1\",		\"channel\": \"WEB\"	},	\"ReducedDataIndicator\": false,	\"RoutingType\": \"R\",	\"TargetSource\": \"BrandedFares\",  	\"PassengerTypeQuantity\": [{		\"Code\": \"adult\",		\"Quantity\": 1	},	{		\"Code\": \"child\",		\"Quantity\": 1	},	{		\"Code\": \"infant\",		\"Quantity\": 0	}],	\"OriginDestinationInformation\": [{		\"DepartureDateTime\": {			\"WindowAfter\": \"P0D\",			\"WindowBefore\": \"P0D\",			\"Date\": \"14JAN\"		},		\"OriginLocation\": {			\"LocationCode\": \"IST\",			\"MultiAirportCityInd\": false		},		\"DestinationLocation\": {			\"LocationCode\": \"ESB\",			\"MultiAirportCityInd\": false		},		\"CabinPreferences\": [{			\"Cabin\": \"ECONOMY\"		},		{			\"Cabin\": \"BUSINESS\"		}]	},	{		\"DepartureDateTime\": {			\"WindowAfter\": \"P0D\",			\"WindowBefore\": \"P0D\",			\"Date\": \"19JAN\"		},		\"OriginLocation\": {			\"LocationCode\": \"ESB\",			\"MultiAirportCityInd\": false		},		\"DestinationLocation\": {			\"LocationCode\": \"IST\",			\"MultiAirportCityInd\": false		},		\"CabinPreferences\": [{			\"Cabin\": \"ECONOMY\"		},		{			\"Cabin\": \"BUSINESS\"		}]	}]}".getBytes();
        conn.setFixedLengthStreamingMode(body.length);
        conn.setDoOutput(true);

        OutputStream out = conn.getOutputStream();
        out.write(body);
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        System.out.println(sb.toString());
    }
}
