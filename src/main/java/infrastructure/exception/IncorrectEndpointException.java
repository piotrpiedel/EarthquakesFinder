package infrastructure.exception;

import java.io.IOException;

public class IncorrectEndpointException extends IOException {

    public IncorrectEndpointException(String message) {
        super(message);
    }

    public IncorrectEndpointException(String message, Throwable cause) {
        super(message, cause);
    }

    public IncorrectEndpointException(Throwable cause) {
        super(cause);
    }
}
