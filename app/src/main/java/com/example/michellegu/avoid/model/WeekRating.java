package com.example.michellegu.avoid.model;
import com.example.michellegu.avoid.model.EnumTypes.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by michellegu on 4/28/17.
 */

public class WeekRating {

    private DayRating[] days;


    public WeekRating() {
        this.days = new DayRating[7];
    }

    public WeekRating(DayRating[] days) {
        this.days = days;
    }

    public DayRating[] getDays() {
        return days;
    }

    public void setDays(DayRating[] days) {
        this.days = days;
    }

    public void addDayRating(Day day) {
        days[day.getValue()] = new DayRating();
    }

    public void removeDayRating(Day day) {
        days[day.getValue()] = null;
    }

    public ArrayList<Day> getDaysOpened() {
        ArrayList<Day> result = new ArrayList<>();
        for(DayRating dr: days) {
            if(dr != null) {
                result.add(dr.getDay());
            }
        }
        return result;
    }

    public DayRating getDayRating(Day day) {
        return days[day.getValue()];
    }

}
