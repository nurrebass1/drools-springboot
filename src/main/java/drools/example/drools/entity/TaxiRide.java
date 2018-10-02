package drools.example.drools.entity;

import lombok.Data;

@Data
public class TaxiRide {

    private Boolean isNightSurcharge;
    private Long distanceInMile;
}
