package service;
import com.fasterxml.jackson.databind.ObjectMapper;
import request.RequestFromTheAirport;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service
public class TheAirportService {

    public List<Double>  getMaxPrice(RequestFromTheAirport requestFromTheAirport) {
        List<Double> matchingPrices = new ArrayList<>();
        try {
            ObjectMapper mapper = new ObjectMapper();
            ClassPathResource resource = new ClassPathResource("flightsInfo.json");
            List<Map<String, Object>> information = mapper.readValue(resource.getInputStream(), List.class);

            for (Map<String, Object> data : information) {
                if (    data.get("domainDate").equals(requestFromTheAirport.getDomainDate()) &&
                        data.get("domainCity").equals(requestFromTheAirport.getDomainCity())
                ) {
                    matchingPrices.add(Double.parseDouble(data.get("maxPrice").toString()));
                }
                if (matchingPrices.isEmpty()) {
                    System.out.println("not found.");
                }
            }
            return matchingPrices;

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("error: " + e.getMessage());
            return null;
        }
    }}
