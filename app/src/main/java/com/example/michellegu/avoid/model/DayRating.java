package com.example.michellegu.avoid.model;
import com.example.michellegu.avoid.model.EnumTypes.Day;

/**
 * Created by michellegu on 4/28/17.
 */

public class DayRating {

    private Day day;
    private int openingHour;
    private int closingHour;
    private int[] hourRatings;

    public int getOpeningHour() {
        return openingHour;
    }

    public void setOpeningHour(int openingHour) {
        this.openingHour = openingHour;
    }

    public int getClosingHour() {
        return closingHour;
    }

    public void setClosingHour(int closingHour) {
        this.closingHour = closingHour;
    }

    public int[] getHourRatings() {
        return hourRatings;
    }

    public void setHourRatings(int[] hoursRating) {
        this.hourRatings = hoursRating;
    }

    public int getHourRating(int hour) {
        return hourRatings[hour];
    }

    public int setHourRating(int hour, int rating) {
        return hourRatings[hour] = rating;
    }

    public Day getDay() {
        return day;
    }

    public void setDay(Day day) {
        this.day = day;
    }
}
