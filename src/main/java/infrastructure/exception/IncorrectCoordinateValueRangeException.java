package infrastructure.exception;

public class IncorrectCoordinateValueRangeException extends Exception {

    public IncorrectCoordinateValueRangeException(String message) {
        super(message);
    }

    public IncorrectCoordinateValueRangeException(String message, Throwable cause) {
        super(message, cause);
    }

    public IncorrectCoordinateValueRangeException(Throwable cause) {
        super(cause);
    }
}
