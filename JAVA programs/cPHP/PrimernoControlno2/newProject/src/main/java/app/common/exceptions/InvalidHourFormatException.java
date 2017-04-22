package app.common.exceptions;

/**
 * Created by Ico on 25.1.2017 г..
 */
public class InvalidHourFormatException extends CreateEventException {
    public InvalidHourFormatException() {
        super("Please enter a valid hour format");
    }
}
