package controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import request.RequestFromTheAirport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import service.TheAirportService;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TheAirportController {
    private static final Logger logger = LoggerFactory.getLogger(TheAirportController.class);

    private TheAirportService theAirportService;

    @Autowired
    public TheAirportController(TheAirportService theAirportService){
        this.theAirportService = theAirportService;
        logger.info("TheAirportController initialized with service: {}", theAirportService.getClass().getName());
    }

    @PostMapping("/getPrice")
    public List<Double> getMaxPrice(@RequestBody RequestFromTheAirport requestFromTheAirport){
        logger.info("getPrice endpoint called with request: {}", requestFromTheAirport.toString());
        List<Double> prices = theAirportService.getMaxPrice(requestFromTheAirport);
        logger.info("Returned prices: {}", prices.toString());
        return prices;
    }
}
