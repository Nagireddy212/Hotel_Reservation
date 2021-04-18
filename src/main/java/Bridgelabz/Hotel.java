package Bridgelabz;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.stream.Stream;

public class Hotel {
    String hotelName;
    Integer hotelRating;
    HashMap<CustomerType, RateKey> rate;

    public Hotel(){}

    public Hotel(String hotelName, Integer hotelRating, HashMap<CustomerType, RateKey> rate) {
        this.hotelName = hotelName;
        this.hotelRating = hotelRating;
        this.rate = rate;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public Integer getHotelRating() {
        return hotelRating;
    }

    public void setHotelRating(Integer hotelRating) {
        this.hotelRating = hotelRating;
    }

    public HashMap<CustomerType, RateKey> getRate() {
        return rate;
    }

    public void setRate(HashMap<CustomerType, RateKey> rate) {
        this.rate = rate;
    }

    public Integer getRateForADateRange(CustomerType customerType, LocalDate startDate , LocalDate endDate){
        return    Stream.iterate(startDate, date -> date.plusDays(1))
                .limit(ChronoUnit.DAYS.between(startDate, endDate) + 1)
                .map(date -> {
                    if (date.getDayOfWeek().equals(DayOfWeek.SATURDAY) || date.getDayOfWeek().equals(DayOfWeek.SUNDAY))
                        return this.rate.get(customerType).getWeekendRates();
                    return this.rate.get(customerType).getWeekdayRates();
                })
                .reduce(Integer::sum).orElse(0);
    }
}