package app.common.exceptions;

/**
 * Created by Ico on 25.1.2017 г..
 */
public class NoMarkerException extends CreateEventException {
    public NoMarkerException() {
        super("Event must have a marker!");
    }
}
