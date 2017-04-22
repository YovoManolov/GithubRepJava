package app.bussinessLayer.CalendarElements.Years.Interfaces;

import app.bussinessLayer.CalendarElements.Months.Interfaces.Month;

/**
 * Created by Ico on 3.1.2017 г..
 */
public interface Year {
    Month getMonth(int monthNumber);

    int getNumber();
}
