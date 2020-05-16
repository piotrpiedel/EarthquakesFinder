package domain.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
public class Coordinates {

    private final Longitude longitude;
    private final Latitude latitude;

}
