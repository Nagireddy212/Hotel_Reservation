package Bridgelabz;

public class RateKey {
    private Integer weekendRates;
    private Integer weekdayRates;

    public RateKey(Integer weekEndRates, Integer weekDayRates) {
        this.weekendRates = weekEndRates;
        this.weekdayRates = weekDayRates;
    }

    public void setWeekendRates(Integer weekendRates) {
        this.weekendRates = weekendRates;
    }

    public void setWeekdayRates(Integer weekdayRates) {
        this.weekdayRates = weekdayRates;
    }

    public Integer getWeekendRates() {
        return this.weekendRates;
    }

    public Integer getWeekdayRates() {
        return this.weekdayRates;
    }

    @Override
    public String toString() {
        return "Rate{" +
                "weekendRates=" + weekendRates +
                ", weekdayRates=" + weekdayRates +
                '}';
    }
}
