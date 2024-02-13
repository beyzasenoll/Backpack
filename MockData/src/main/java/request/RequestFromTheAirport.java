package request;

import lombok.Data;

@Data
public class RequestFromTheAirport {
    public String domainDate;
    public String domainCity;
    public int passenger_count;
    public String domainTime;


}
