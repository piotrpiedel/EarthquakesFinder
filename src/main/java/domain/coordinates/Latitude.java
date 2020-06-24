package domain.coordinates;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Latitude extends GeographicCoordinate {

    public Latitude(double value) {
        super(value);
    }
}
