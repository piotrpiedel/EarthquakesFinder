package domain;

import java.util.Objects;

public class EarthquakeBasicInfoWithDistanceToPoint implements Comparable<EarthquakeBasicInfoWithDistanceToPoint> {

    private EarthquakeBasicInfo earthquakeBasicInfo;
    private Double distanceToEarthquake;

    public EarthquakeBasicInfoWithDistanceToPoint(EarthquakeBasicInfo earthquakeBasicInfo, double distanceToEarthquake) {
        this.earthquakeBasicInfo = earthquakeBasicInfo;
        this.distanceToEarthquake = distanceToEarthquake;
    }

    public EarthquakeBasicInfo getEarthquakeBasicInfo() {
        return earthquakeBasicInfo;
    }

    public Double getDistanceToEarthquake() {
        return distanceToEarthquake;
    }

    @Override
    public int compareTo(EarthquakeBasicInfoWithDistanceToPoint earthquakeBasicInfoWithDistanceToPoint) {
        return this.distanceToEarthquake.compareTo(earthquakeBasicInfoWithDistanceToPoint.distanceToEarthquake);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EarthquakeBasicInfoWithDistanceToPoint that = (EarthquakeBasicInfoWithDistanceToPoint) o;
        return Objects.equals(earthquakeBasicInfo, that.earthquakeBasicInfo) &&
                Objects.equals(distanceToEarthquake, that.distanceToEarthquake);
    }

    @Override
    public int hashCode() {
        return Objects.hash(earthquakeBasicInfo, distanceToEarthquake);
    }
}
