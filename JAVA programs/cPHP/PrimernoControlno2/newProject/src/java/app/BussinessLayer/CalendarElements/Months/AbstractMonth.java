package app.bussinessLayer.CalendarElements.Months;

import app.bussinessLayer.CalendarElements.Days.DayImpl;
import app.bussinessLayer.CalendarElements.Days.Interfaces.Day;
import app.bussinessLayer.CalendarElements.Months.Interfaces.Month;

/**
 * Created by Ico on 3.1.2017 г..
 */
public abstract class AbstractMonth implements Month{
    private Day[] days;

    public AbstractMonth(int numberOfdays) {
        Day[] days = new Day[numberOfdays];

        for (int i = 0; i < numberOfdays; i++){
            days[i] = new DayImpl();
        }

        this.setDays(days);
    }

    @Override
    public Day getDay(int dayNumber) {
        return this.days[dayNumber];
    }

    private void setDays(Day[] days) {
        this.days = days;
    }
}
