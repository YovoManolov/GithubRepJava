package app.bussinessLayer.Services;

import app.bussinessLayer.Factories.FactoryProducer;
import app.bussinessLayer.Factories.Interfaces.EventFactory;
import app.bussinessLayer.Services.Interfaces.EventService;
import app.common.models.ViewModels.EventView;
import app.dataLayer.domain.models.EventDA;
import app.dataLayer.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Ico on 28.12.2016 г..
 */
@Service(value = "eventService")
public class EventServiceImpl implements EventService {

    @Autowired
    private FactoryProducer factoryProducer = new FactoryProducer();

    @Autowired
    @Qualifier("eventRepository")
    private EventRepository eventRepository;


    @Override
    public void registerEvent(EventView eventToRegister) {
        EventFactory factory = factoryProducer.createFactory(eventToRegister.getType());

        EventDA entityEvent = factory.createEvent(eventToRegister);

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
    public List<EventDA> getEvents()
    {
        List<EventDA> allEvents = (List<EventDA>) eventRepository.findAll();

        return allEvents;
    }

    @Override
    public EventDA getEventByName(String name) {
        return eventRepository.findOneByName(name);

    }



}
