package domain;

public class Latitude extends GeographicCoordinate {
    private static final double LOWEST_LATITUDE = -90.0;
    private static final double HIGHEST_LATITUDE = 90.0;

    public Latitude(double value) {
        super(value);
    }

    public Latitude(String value) {
        super(value);
    }

    @Override
    protected double getLowestValue() {
        return LOWEST_LATITUDE;
    }

    @Override
    protected double getHighestValue() {
        return HIGHEST_LATITUDE;
    }



}
