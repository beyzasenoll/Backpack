package request;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestFromTheAirport {
    public String domainDate;
    public String domainCity;
    public int passenger_count;
    //public String domainTime;


}
