package com.backpack.BackpackTravelApp.service.MyWayApiService;

import com.backpack.BackpackTravelApp.request.Request;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class MyWayApiService {
    public List<Double> getMaxPrice(Request request) {
        List<Double> matchingPrices = new ArrayList<>();
        try {
            // JSON dosyasını oku
            ObjectMapper mapper = new ObjectMapper();
            ClassPathResource resource = new ClassPathResource("flights.json");
            List<Map<String, Object>> information = mapper.readValue(resource.getInputStream(), List.class);

            // Request verilerine uygun objeyi bul
            for (Map<String, Object> data : information) {
                if (data.get("departureDate").equals(request.getDepartureDate()) &&
                        data.get("departureCity").equals(request.getDepartureCity())
                ) {
                    matchingPrices.add(Double.parseDouble(data.get("max_price").toString()));

                }


                if (matchingPrices.isEmpty()) {
                    System.out.println("Bu kriterlere uygun uçuş bulunamadı.");
                }
            }
            return matchingPrices;
        }catch (IOException e) {
            e.printStackTrace();
            // Hata durumunda uygun bir hata mesajı döndür
            System.out.println("Hata oluştu: " + e.getMessage());
            return null;
        }
    }
}
