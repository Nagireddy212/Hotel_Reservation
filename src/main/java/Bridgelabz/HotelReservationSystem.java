package Bridgelabz;

import javax.xml.transform.Result;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

public class HotelReservationSystem {
    ArrayList<Hotel> hotelList;

    public HotelReservationSystem() {
        this.hotelList = new ArrayList<>();
    }

    public void addHotel(Hotel hotelToAdd){
        this.hotelList.add(hotelToAdd);
    }

    public Hotel getHotelByName(String hotelNameToSearchFor){
        Hotel hotelToSearchFor = new Hotel();
        for (Hotel hotel : this.hotelList) {
            if(hotel.hotelName.equals(hotelNameToSearchFor)){
                return hotel;
            }
        }
        System.out.println("Hotel with name " + hotelNameToSearchFor + "is not available in our records.");
        return null;
    }

    public Result getCheapestRateForADateRange(CustomerType customerType, LocalDate startDate , LocalDate endDate){
        ArrayList<Result> allHotelRateList= this.getAllRateForADateRange(customerType,startDate,endDate);
        ArrayList<Result> cheapest3HotelRateList= (ArrayList<Result>) allHotelRateList.stream()
                .sorted(new ResultComparator())
                .limit(3)
                .collect(Collectors.toList());
        return cheapest3HotelRateList.get(0);
    }

    public Result getBestRatedHotelForADateRange(CustomerType customerType, LocalDate startDate , LocalDate endDate){
        ArrayList<Result> allHotelRateList= this.getAllRateForADateRange(customerType,startDate,endDate);
        ArrayList<Result> cheapest3HotelRateList= (ArrayList<Result>) allHotelRateList.stream()
                .sorted(Comparator.comparingInt(Result::getHotelRating).reversed())
                .limit(3)
                .collect(Collectors.toList());
        return cheapest3HotelRateList.get(0);
    }

    private ArrayList<Result> getAllRateForADateRange(CustomerType customerType, LocalDate startDate , LocalDate endDate){
        return (ArrayList<Result>) hotelList.stream()
                .map(hotel -> {
                    Result newResult = new Result();
                    newResult.setHotelName(hotel.getHotelName());
                    newResult.setHotelRating(hotel.getHotelRating());
                    newResult.setTotalCalculatedRate(hotel.getRateForADateRange(customerType, startDate, endDate));
                    return newResult;
                })
                .collect(Collectors.toList());
    }
}