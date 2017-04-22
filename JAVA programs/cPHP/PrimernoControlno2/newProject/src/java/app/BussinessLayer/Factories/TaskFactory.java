package app.bussinessLayer.Factories;

import app.bussinessLayer.Factories.Interfaces.EventFactory;
import app.common.enums.Marker;
import app.common.models.ViewModels.EventView;
import app.dataLayer.domain.models.EventDA;
import app.dataLayer.domain.models.TaskDA;

import java.util.Date;

/**
 * Created by Ico on 29.12.2016 г..
 */
public class TaskFactory implements EventFactory {

    @Override
    public EventDA createEvent(EventView inputEvent) {
        TaskDA createdEvent = new TaskDA();
        Date meetingDate = new Date();

        createdEvent.setName(inputEvent.getName());
        createdEvent.setDescription(inputEvent.getDescription());
        createdEvent.setMarker(Marker.valueOf(inputEvent.getMarker()));


        meetingDate.setDate(Integer.parseInt(inputEvent.getDay()));
        meetingDate.setMonth(Integer.parseInt(inputEvent.getMonth()));
        meetingDate.setYear(Integer.parseInt(inputEvent.getYear()));
        meetingDate.setHours(Integer.parseInt(inputEvent.getHour()));
        meetingDate.setMinutes(Integer.parseInt(inputEvent.getMinutes()));

        return createdEvent;
    }
}
