package app.common.exceptions;

/**
 * Created by Ico on 26.1.2017 г..
 */
public class NoDateException extends CreateEventException {
    public NoDateException() {
        super("Please select a date");
    }
}
