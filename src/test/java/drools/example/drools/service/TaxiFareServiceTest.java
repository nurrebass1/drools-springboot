package drools.example.drools.service;

import drools.example.drools.config.DroolsConfig;
import drools.example.drools.entity.Fare;
import drools.example.drools.entity.TaxiRide;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DroolsConfig.class)
public class TaxiFareServiceTest {

    @Autowired
    TaxiFareService taxiFareService;

    @Test
    public void whenNightSurchargeFalseAndDistLessThan10_thenFixWithoutNightSurcharge() {
        TaxiRide taxiRide = new TaxiRide();
        taxiRide.setIsNightSurcharge(false);
        taxiRide.setDistanceInMile(9L);
        Fare rideFare = new Fare();
        Long totalCharge = this.taxiFareService.calculateFare(taxiRide, rideFare);

        assertNotNull(totalCharge);
        assertEquals(Long.valueOf(70), totalCharge);
    }
}