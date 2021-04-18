package Bridgelabz;

import java.util.HashMap;

public class Hotel{
    String hotelName;
    Integer hotelRating;
    HashMap<CustomerType, RateKey> rate;

    public Hotel(){}

    public Hotel(String hotelName, Integer hotelRating, HashMap<CustomerType, RateKey> rate) {
        this.hotelName = hotelName;
        this.hotelRating = hotelRating;
        this.rate = rate;
    }
}