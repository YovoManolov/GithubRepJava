package app.bussinessLayer.Services.Interfaces;

import app.common.models.ViewModels.EventView;
import app.dataLayer.domain.models.EventDA;

import java.util.List;

/**
 * Created by Ico on 28.12.2016 г..
 */
public interface EventService {
    void registerEvent(EventView eventToRegister);

    void updateEvent(EventDA eventToUpdate);

    void deleteEvent(EventDA eventToDelete);

    List<EventDA> getEvents();

    EventDA getEventByName(String name);


}
