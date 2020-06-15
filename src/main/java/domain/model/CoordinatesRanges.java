package domain.model;

/**
 * @author Piotr
 */

public enum CoordinatesRanges {

    LATITUDE(-90.0d, 90.0d),
    LONGITUDE(-180.0, 180.0);

    private final double lowestValue;
    private final double highestValue;

    CoordinatesRanges(double lowestValue, double highestValue) {
        this.lowestValue = lowestValue;
        this.highestValue = highestValue;
    }

    public double getLowestValue() {
        return lowestValue;
    }

    public double getHighestValue() {
        return lowestValue;
    }
}
