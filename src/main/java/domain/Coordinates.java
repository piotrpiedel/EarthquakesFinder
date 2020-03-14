package domain;

import org.geojson.Point;

import java.util.Objects;

public class Coordinates {
    private Latitude latitude;
    private Longitude longitude;

    public Coordinates(Latitude latitude, Longitude longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Coordinates(Point point) {
        this.latitude = new Latitude(point.getCoordinates().getLatitude());
        this.longitude = new Longitude(point.getCoordinates().getLatitude());
    }

    public Longitude getLongitude() {
        return longitude;
    }

    public Latitude getLatitude() {
        return latitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return Objects.equals(latitude, that.latitude) &&
                Objects.equals(longitude, that.longitude);
    }

    @Override
    public int hashCode() {
        return Objects.hash(latitude, longitude);
    }

    @Override
    public String toString() {
        return "{latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
