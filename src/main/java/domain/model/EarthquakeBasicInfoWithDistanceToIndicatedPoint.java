package domain.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
public class EarthquakeBasicInfoWithDistanceToIndicatedPoint implements
        Comparable<EarthquakeBasicInfoWithDistanceToIndicatedPoint> {

    private final EarthquakeBasicInfo earthquakeBasicInfo;
    private final Double distanceToEarthquake;

    @Override
    public int compareTo(
            EarthquakeBasicInfoWithDistanceToIndicatedPoint earthquakeBasicInfoWithDistanceToIndicatedPoint) {
        return distanceToEarthquake
                .compareTo(earthquakeBasicInfoWithDistanceToIndicatedPoint.distanceToEarthquake);
    }
}
