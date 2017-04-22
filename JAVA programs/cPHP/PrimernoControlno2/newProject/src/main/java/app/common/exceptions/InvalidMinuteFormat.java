package app.common.exceptions;

/**
 * Created by Ico on 25.1.2017 г..
 */
public class InvalidMinuteFormat extends CreateEventException {
    public InvalidMinuteFormat() {
        super("Please enter a valid minute format!");
    }
}
