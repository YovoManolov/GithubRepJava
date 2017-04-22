package app.bussinessLayer.Services.Interfaces;

import app.dataLayer.domain.models.EventDA;

import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by Ico on 3.1.2017 г..
 */
public interface EventCalendarService {
    void bootCalendar();

    List<EventDA> getEventsAt(Date date);

    void add(EventDA eventToAdd);

    void add(Set<EventDA> eventsToAdd);
}
