package app.common.exceptions;

/**
 * Created by Ico on 25.1.2017 г..
 */
public class NoNameException extends CreateEventException {
    public NoNameException() {
        super("Event must have a unique name!");
    }
}
