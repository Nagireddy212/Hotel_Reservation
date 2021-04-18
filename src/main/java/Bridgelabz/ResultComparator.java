package Bridgelabz;

import java.util.Comparator;
public class ResultComparator implements Comparator<Result> {
    @Override
    public int compare(Result result1, Result result2) {
        int compareValue = result1.getTotalCalculatedRate().compareTo(result2.getTotalCalculatedRate());
        if (compareValue == 0)
            compareValue = result2.getHotelRating().compareTo(result1.getHotelRating());
        return compareValue;
    }
}