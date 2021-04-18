import Bridgelabz.CustomerType;
import Bridgelabz.Hotel;
import Bridgelabz.HotelReservationSystem;
import Bridgelabz.RateKey;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import javax.xml.transform.Result;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

public class HotelReservationSystemTest {
    HotelReservationSystem runnerObject;
    Hotel lakewood;
    Hotel bridgewood;
    Hotel ridgewood;

    @Before
    public void setUp(){
        runnerObject = new HotelReservationSystem();
        HashMap<CustomerType, RateKey> hotelRateVariable = new HashMap<>();
        hotelRateVariable.put(CustomerType.REGULAR , new RateKey(90, 110));
        hotelRateVariable.put(CustomerType.REWARD , new RateKey(80, 80));
        lakewood = new Hotel("Lakewood", 3, hotelRateVariable);

        hotelRateVariable = new HashMap<>();
        hotelRateVariable.put(CustomerType.REGULAR , new RateKey(60, 160));
        hotelRateVariable.put(CustomerType.REWARD , new RateKey(50, 110));
        bridgewood = new Hotel("Bridgewood", 4, hotelRateVariable);

        hotelRateVariable = new HashMap<>();
        hotelRateVariable.put(CustomerType.REGULAR , new RateKey(150, 220));
        hotelRateVariable.put(CustomerType.REWARD , new RateKey(40, 100));
        ridgewood = new Hotel("Ridgewood", 5, hotelRateVariable);

        runnerObject.addHotel(lakewood);
        runnerObject.addHotel(bridgewood);
        runnerObject.addHotel(ridgewood);
    }

    @Test
    public void givenInputOfHotelDetails_AddHotelToHotelReservationSystem_ReturnTrueIfInfoCorrectlyAdded(){
        boolean testVariable = runnerObject.getHotelByName("Lakewood").hotelName.equals("Lakewood")
                && runnerObject.getHotelByName("Lakewood").hotelRating == 3
                && runnerObject.getHotelByName("Lakewood").rate.get(CustomerType.REGULAR).getWeekdayRates() == 110
                && runnerObject.getHotelByName("Lakewood").rate.get(CustomerType.REWARD).getWeekdayRates() == 80
                && runnerObject.getHotelByName("Lakewood").rate.get(CustomerType.REGULAR).getWeekendRates() == 90
                && runnerObject.getHotelByName("Lakewood").rate.get(CustomerType.REWARD).getWeekendRates() == 80;
        Assertions.assertTrue(testVariable);
    }

    @Test
    public void givenInputOfHotelDetailsAndDateRange_GetCheapestRate_ReturnTrueIfCheapestRateIsReturned(){
        String startDate = "03Apr2021";
        String endDate = "04Apr2021";

        Result cheapestRateRegular = runnerObject.showCheapestThreeRateForADateRangeReturnCheapest(CustomerType.REGULAR ,
                LocalDate.parse( startDate, DateTimeFormatter.ofPattern("ddMMMyyyy")),
                LocalDate.parse( endDate, DateTimeFormatter.ofPattern("ddMMMyyyy")));

        Result cheapestRateReward = runnerObject.showCheapestThreeRateForADateRangeReturnCheapest(CustomerType.REWARD ,
                LocalDate.parse(startDate, DateTimeFormatter.ofPattern("ddMMMyyyy")),
                LocalDate.parse(endDate, DateTimeFormatter.ofPattern("ddMMMyyyy")));

        Assertions.assertEquals(120 , (int) cheapestRateRegular.getTotalCalculatedRate());
        Assertions.assertEquals(80 , (int) cheapestRateReward.getTotalCalculatedRate());
    }
}
