package app.common.models.ViewModels;

import app.common.exceptions.*;

import java.util.Calendar;

/**
 * Created by Ico on 28.12.2016 г..
 */
public abstract class EventView {

    private String name;

    private String marker;

    private Calendar date;

    private String description;

    private String type;


    public EventView() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws CreateEventException {
        if (name == null || name.isEmpty()){
            throw new NoNameException();
        }

        this.name = name;
    }

    public String getMarker() {
        return marker;
    }

    public void setMarker(String marker) throws CreateEventException{
        if (marker == null || marker.isEmpty()){
            throw new NoMarkerException();
        }

        this.marker = marker;
    }

    public void setHour(String hour) throws CreateEventException {
        if (Integer.parseInt(hour) > 23){
            throw new InvalidHourFormatException();
        }

        this.date.add(Calendar.HOUR, Integer.parseInt(hour));
    }

    public void setMinutes(String minutes) throws CreateEventException {
        if (Integer.parseInt(minutes) >59){
            throw new InvalidMinuteFormat();
        }

        this.date.add(Calendar.MINUTE, Integer.parseInt(minutes));
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) throws CreateEventException{
        if (date == null){
            throw new NoDateException();
        }

        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) throws CreateEventException{
        if (description == null || description.isEmpty()){
            throw new EmptyDescriptionException();
        }
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
