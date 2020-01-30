package domain;

import org.geojson.Point;

public class EarthquakePlaceToCoordinates {
    private String place;
    private Coordinates coordinates;

    public EarthquakePlaceToCoordinates() {

    }

    public EarthquakePlaceToCoordinates(String place, Point point) {
        this.place = place;
        this.coordinates = new Coordinates(point.getCoordinates().getLatitude(), point.getCoordinates().getLongitude());
    }

    public EarthquakePlaceToCoordinates(String place, Coordinates coordinates) {
        this.place = place;
        this.coordinates = coordinates;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }


    @Override
    public String toString() {
        return "Earthquake{" +
                "place='" + place + '\'' +
                ", coordinates=" + coordinates +
                '}';
    }
}
