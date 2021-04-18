package Bridgelabz;

import java.util.Comparator;

public class ResultComparator implements Comparator<Result> {
    @Override
    public int compare(Result result, Result t1) {
        return result.getTotalCalculatedRate().compareTo(t1.getTotalCalculatedRate());
    }
}