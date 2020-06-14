package infrastructure.exception;

public class IncorrectCoordinateValueException extends Exception {

    public IncorrectCoordinateValueException(String message) {
        super(message);
    }

    public IncorrectCoordinateValueException(String message, Throwable cause) {
        super(message, cause);
    }

    public IncorrectCoordinateValueException(Throwable cause) {
        super(cause);
    }
}
