package app.bussinessLayer.CalendarElements.Months.Interfaces;

import app.bussinessLayer.CalendarElements.Days.Interfaces.Day;

/**
 * Created by Ico on 3.1.2017 г..
 */
public interface Month {
    Day getDay(int dayNumber);
}
