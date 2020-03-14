package domain;

public class Longitude extends GeographicCoordinate {
    private static final double LOWEST_LONGITUDE = -180.0;
    private static final double HIGHEST_LONGITUDE = 180.0;

    public Longitude(double value) {
        super(value);
    }

    public static Longitude parseValueToLongitude(String line) {
        return new Longitude(parse(line, LOWEST_LONGITUDE, HIGHEST_LONGITUDE));
    }
}
