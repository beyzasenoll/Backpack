package com.backpack.BackpackTravelApp.service.MyWayApiService;

import com.backpack.BackpackTravelApp.request.Request;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service
public class MyWayApiService {
    public double getMaxPrice(Request request) {
        try {
            // JSON dosyasını oku
            ObjectMapper mapper = new ObjectMapper();
            ClassPathResource resource = new ClassPathResource("flights.json");
            List<Map<String, Object>> information = mapper.readValue(resource.getInputStream(), List.class);

            // Request verilerine uygun objeyi bul
            for (Map<String, Object> data : information) {
                if (    data.get("departureDate").equals(request.getDepartureDate()) &&
                        data.get("departureCity").equals(request.getDepartureCity())
                        ) {

                    // Eşleşen objeyi bulduk, max_price değerini döndür
                    return Double.parseDouble(data.get("max_price").toString());
                }
            }

            // Eşleşen obje bulunamadıysa 0.0 döndür
            return 0.0;   // Error mesajı veya veri döndürecek şekilde yeniden düzenlersin. "Bu kriterlere uygun uçuş bulunamadı" tarzı bir mesaj dönsün

        } catch (IOException e) {
            e.printStackTrace();
            return 00000.00000; // Hata durumunda 00000.00000 döndür
        }
    }
}