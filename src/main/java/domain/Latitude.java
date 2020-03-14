package domain;

public class Latitude extends GeographicCoordinate {
    public static final double LOWEST_LATITUDE = -90.0;
    public static final double HIGHEST_LATITUDE = 90.0;

    public Latitude(double value) {
        super(value);
    }

    public static Latitude parseValueToLatitude(String line) {
        return new Latitude(parse(line, LOWEST_LATITUDE, HIGHEST_LATITUDE));
    }
}
