package controller;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.apache.coyote.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import request.RequestFromTheAirport;
import service.TheAirportService;

@RestController
@Data
public class TheAirportController {
    private TheAirportService theAirportService;

    @Autowired TheAirportController(TheAirportService theAirportService){
        this.theAirportService = theAirportService;
    }

    @PostMapping("/getMaxPrice")
    public double getMaxPrice(@RequestBody Request request){
        return theAirportService.getMaxPrice(new RequestFromTheAirport());
    }

}
