package domain.coordinates;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Longitude extends GeographicCoordinate {

    public Longitude(double value) {
        super(value);
    }

}
