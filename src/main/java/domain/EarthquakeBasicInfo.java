package domain;

import org.geojson.Feature;
import org.geojson.Point;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class EarthquakeBasicInfo {
    private String place;
    private Coordinates coordinates;

    public EarthquakeBasicInfo(String place, Point point) {
        this.place = place;
        this.coordinates = new Coordinates(point);
    }

    public EarthquakeBasicInfo(String place, Coordinates coordinates) {
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

    public static List<EarthquakeBasicInfo> mapFeaturesToEarthquakePlaceToCoordinatesList(List<Feature> featureList) {
        return featureList
                .stream()
                .map(it -> new EarthquakeBasicInfo(it.getProperty("place"), (Point) it.getGeometry()))
                .collect(Collectors.toList());
    }

    public static List<EarthquakeBasicInfo> filterEarthquakesWithCoordinatesDuplicates(List<EarthquakeBasicInfo> earthquakeBasicInfoList) {
        Set<Coordinates> set = new HashSet<>();
        return earthquakeBasicInfoList
                .stream()
                .filter(p -> set.add(p.getCoordinates()))
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "Earthquake{" +
                "place='" + place + '\'' +
                ", coordinates=" + coordinates +
                '}';
    }
}
