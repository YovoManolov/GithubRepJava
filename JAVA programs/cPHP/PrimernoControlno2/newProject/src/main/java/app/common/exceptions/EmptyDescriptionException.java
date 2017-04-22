package app.common.exceptions;

/**
 * Created by Ico on 25.1.2017 г..
 */
public class EmptyDescriptionException extends CreateEventException {
    public EmptyDescriptionException() {
        super("Event must have a description!");
    }
}
