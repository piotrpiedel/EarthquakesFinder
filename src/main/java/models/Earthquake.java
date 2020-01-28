package models;

import org.geojson.Point;

public class Earthquake {
    private String place;
    private Coordinates coordinates;

    public Earthquake(String place, Point point) {
        this.place = place;
        this.coordinates = new Coordinates(point.getCoordinates().getLatitude(), point.getCoordinates().getLongitude());
    }

    public Earthquake(String place, Coordinates coordinates) {
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
