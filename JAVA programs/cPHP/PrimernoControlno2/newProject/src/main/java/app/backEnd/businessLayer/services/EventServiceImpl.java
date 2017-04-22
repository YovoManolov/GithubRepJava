package app.backEnd.businessLayer.services;

import app.backEnd.businessLayer.factories.FactoryProducer;
import app.backEnd.businessLayer.factories.interfaces.EventFactory;
import app.backEnd.businessLayer.services.interfaces.EventService;
import app.backEnd.businessLayer.services.interfaces.UserService;
import app.backEnd.dataLayer.repositories.EventRepository;
import app.common.models.ViewModels.EventView;
import app.common.models.daModels.eventModels.EventDA;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Ico on 28.12.2016 г..
 */
@Service
@Qualifier(value = "eventService")
public class EventServiceImpl implements EventService {

    private FactoryProducer factoryProducer = new FactoryProducer();

    private EventRepository eventRepository;

    private UserService userService;

    public EventServiceImpl() {
    }

    public EventServiceImpl(EventRepository eventRepository, UserService userService) {
        this.setEventRepository(eventRepository);
        this.userService = userService;
    }

    @Override
    public void registerEvent(EventView eventToRegister, String ownerName) {
        EventFactory factory = factoryProducer.createFactory(eventToRegister.getType());

        EventDA entityEvent = factory.createEvent(eventToRegister);

        entityEvent.setOwner(userService.getUser(ownerName));

        eventRepository.save(entityEvent);
    }

    @Override
    public void updateEvent(EventDA eventToUpdate) {
        eventRepository.save(eventToUpdate);
    }

    @Override
    public void deleteEvent(EventDA eventToDelete) {
        eventRepository.delete(eventToDelete);
    }

    @Override
    public List <EventDA> getEvents()
    {
        List<EventDA> allEvents = (List<EventDA>) eventRepository.findAll();
        return allEvents;
    }

    @Override
    public EventDA getEventByName(String name) {
        return eventRepository.findOneByName(name);
    }

    private void setEventRepository(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public List<EventDA> getEventsByDate(Calendar date){
        List<EventDA> events = this.getEvents();
        List<EventDA> result = new ArrayList<>();

        for (EventDA event : events) {
            Calendar eventDate = event.getDateTime();
            if (eventDate.get(Calendar.DATE) == date.get(Calendar.DATE)){
                result.add(event);
            }
        }

        return result;
    }

    @Override
    public List<EventDA> getEventsByMonth(int month, int year) {
        List<EventDA> allEvents = getEvents();
        List<EventDA> result = new ArrayList<>();

        for (EventDA event : allEvents) {
            Calendar dateTimeOfEvent = event.getDateTime();
            if (dateTimeOfEvent.get(Calendar.MONTH) == month &&
                    dateTimeOfEvent.get(Calendar.YEAR) == year){
                result.add(event);
            }
        }

        return result;
    }
}
