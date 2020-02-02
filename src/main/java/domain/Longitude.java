package domain;

public class Longitude extends GeographicCoordinate {
    private static final double LOWEST_LONGITUDE = -180.0;
    private static final double HIGHEST_LONGITUDE = 180.0;

    public Longitude(double value) {
        super(value);
    }

    public Longitude(String value) {
        super(value);
    }

    @Override
    protected double getLowestValue() {
        return LOWEST_LONGITUDE;
    }

    @Override
    protected double getHighestValue() {
        return HIGHEST_LONGITUDE;
    }

}
