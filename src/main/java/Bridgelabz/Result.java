package Bridgelabz;

public class Result{
    private String hotelName;
    private Integer hotelRating;
    private Integer totalCalculatedRate;

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

    public Integer getTotalCalculatedRate() {
        return totalCalculatedRate;
    }

    public void setTotalCalculatedRate(Integer totalCalculatedRate) {
        this.totalCalculatedRate = totalCalculatedRate;
    }

    @Override
    public String toString() {
        return "\n[" + hotelName + "] with " + "[" + "*".repeat(hotelRating) + "] Rating will cost you Rs."+ totalCalculatedRate + "\n";
    }
}
