package service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.coyote.Request;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import request.RequestFromTheAirport;
import response.ResponseOfTheAirport;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service
public class TheAirportService {

    public double getMaxPrice(RequestFromTheAirport requestFromTheAirport) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            ClassPathResource resource = new ClassPathResource("flightsInfo.json");
            List<Map<String, Object>> information = mapper.readValue(resource.getInputStream(), List.class);

            for (Map<String, Object> data : information) {
                if (    data.get("domainDate").equals(requestFromTheAirport.getDomainDate()) &&
                        data.get("domainCity").equals(requestFromTheAirport.getDomainCity())
                ) {

                    return Double.parseDouble(data.get("max_price").toString());
                }
            }
            return 0.0;
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Error reading flights data from JSON file");
        }
    }}
