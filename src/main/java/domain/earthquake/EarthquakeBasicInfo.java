package domain.earthquake;

import domain.coordinates.Coordinates;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
public class EarthquakeBasicInfo {

    private final String place;
    private final Coordinates coordinates;
}
