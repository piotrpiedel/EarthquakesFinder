package domain.model;

public enum CoordinatesValues {

    LOWEST_LATITUDE(-90.0),
    HIGHEST_LATITUDE(90.0),
    LOWEST_LONGITUDE(-180.0),
    HIGHEST_LONGITUDE(180.0);

    private final double value;

    CoordinatesValues(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}
