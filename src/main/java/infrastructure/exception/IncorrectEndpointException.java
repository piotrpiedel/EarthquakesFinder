package infrastructure.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.io.IOException;

@Getter
@ToString
@AllArgsConstructor
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
