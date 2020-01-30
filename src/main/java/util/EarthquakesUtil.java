package util;

import distancecalc.DistanceCalculator;
import distancecalc.DistanceCalculatorHaversine;
import domain.Coordinates;
import domain.EarthquakePlaceToCoordinates;
import org.geojson.Feature;
import org.geojson.Point;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class EarthquakesUtil {
    public static final DistanceCalculator distanceCalculatorHaversine = new DistanceCalculatorHaversine();

    private EarthquakesUtil() {
        throw new IllegalStateException("Utility class");
    }

    public static List<EarthquakePlaceToCoordinates> mapFeaturesToEarthquakePlaceToCoordinatesList(List<Feature> featureList) {
        return featureList
                .stream()
                .map(it -> new EarthquakePlaceToCoordinates(it.getProperty("place"), (Point) it.getGeometry()))
                .collect(Collectors.toList());
    }

    public static Map<EarthquakePlaceToCoordinates, Double> mapEarthquakesListToEarthQuakesToDistanceMap(List<EarthquakePlaceToCoordinates> earthquakePlaceToCoordinates, Coordinates coordinatesToMeasureDistanceFrom) {
        return earthquakePlaceToCoordinates
                .stream()
                .collect(Collectors.toMap(Function.identity(), it -> distanceCalculatorHaversine.calculateDistance(it.getCoordinates(), coordinatesToMeasureDistanceFrom)));
    }

    public static List<EarthquakePlaceToCoordinates> filterEarthquakesWithCoordinatesDuplicates(List<EarthquakePlaceToCoordinates> earthquakePlaceToCoordinatesList) {
        Set<Coordinates> set = new HashSet<>();
        return earthquakePlaceToCoordinatesList
                .stream()
                .filter(p -> set.add(p.getCoordinates()))
                .collect(Collectors.toList());
    }
}
