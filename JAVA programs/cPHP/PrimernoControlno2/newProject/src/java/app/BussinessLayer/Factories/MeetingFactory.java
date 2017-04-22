package app.bussinessLayer.Factories;

import app.bussinessLayer.Factories.Interfaces.EventFactory;
import app.common.enums.Marker;
import app.common.models.ViewModels.EventView;
import app.common.models.ViewModels.MeetingView;
import app.dataLayer.domain.models.EventDA;
import app.dataLayer.domain.models.MeetingDA;

import java.util.Date;

/**
 * Created by Ico on 29.12.2016 г..
 */
public class MeetingFactory implements EventFactory {

    @Override
    public EventDA createEvent(EventView inputEvent) {
        MeetingView meetingView = (MeetingView) inputEvent;
        MeetingDA createdEvent = new MeetingDA();
        Date meetingDate = new Date();

        createdEvent.setName(meetingView.getName());
        createdEvent.setDescription(meetingView.getDescription());
        createdEvent.setMarker(Marker.valueOf(meetingView.getMarker()));
        createdEvent.setLocation(meetingView.getLocation());

        meetingDate.setDate(Integer.parseInt(meetingView.getDay()));
        meetingDate.setMonth(Integer.parseInt(meetingView.getMonth()));
        meetingDate.setYear(Integer.parseInt(meetingView.getYear()));
        meetingDate.setHours(Integer.parseInt(meetingView.getHour()));
        meetingDate.setMinutes(Integer.parseInt(meetingView.getMinutes()));

        return createdEvent;
    }
}
