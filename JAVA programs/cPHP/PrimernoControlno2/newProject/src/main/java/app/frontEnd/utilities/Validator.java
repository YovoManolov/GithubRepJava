package app.frontEnd.utilities;

import app.backEnd.businessLayer.services.interfaces.EventService;
import app.common.exceptions.CreateEventException;
import app.common.exceptions.EmptyDescriptionException;
import app.common.exceptions.NoMarkerException;
import app.common.exceptions.NoNameException;
import app.common.models.ViewModels.EventView;

/**
 * Created by Ico on 15.1.2017 г..
 */
public class Validator {

    public static void validateEventUniqueness(String name, EventService eventService) throws CreateEventException {

        if (eventService.getEventByName(name) != null){
            throw new NoNameException();
        }
    }

    public static void validateDropDownField(String text){
        if (text.isEmpty() || text == null){
            throw new IllegalArgumentException("Please choose an option!");
        }
    }
}
