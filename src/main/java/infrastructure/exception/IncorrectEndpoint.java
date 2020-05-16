package infrastructure.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.io.IOException;

@Getter
@ToString
@AllArgsConstructor
public class IncorrectEndpoint extends IOException {

    public IncorrectEndpoint(String message) {
        super(message);
    }

    public IncorrectEndpoint(String message, Throwable cause) {
        super(message, cause);
    }

    public IncorrectEndpoint(Throwable cause) {
        super(cause);
    }
}
