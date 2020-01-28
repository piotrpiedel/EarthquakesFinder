import client.MonthSignificantEarthquakes;
import distancecalc.DistanceCalculatorHaversine;
import models.Coordinates;
import models.Earthquake;
import org.geojson.Feature;
import org.geojson.Point;
import util.MapUtil;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;


//Latitude : max/min +90 to -90
//
//Longitude : max/min +180 to -180

public class Main {
    public static void main(String[] args) {
        MonthSignificantEarthquakes monthAllEarthquakes = new MonthSignificantEarthquakes();
        List<Feature> featureList = monthAllEarthquakes.getEarthquakes().getFeatures();
        DistanceCalculatorHaversine distanceCalculatorHaversine = new DistanceCalculatorHaversine();

        Coordinates coordinates = new Coordinates(80, 123.566);

        Map<Earthquake, Double> result2 = featureList
                .stream()
                .map(it -> new Earthquake(it.getProperty("place"), (Point) it.getGeometry()))
                .collect(Collectors.toMap(Function.identity(), it -> distanceCalculatorHaversine.calculateDistance(it.getCoordinates(), coordinates)));
        Map<Earthquake, Double> result3 = MapUtil.sortByValue(result2);


//        Map<Earthquake, Double> result2 = featureList
//                .stream()
//                .map(it -> new Earthquake(it.getProperty("place"), (Point) it.getGeometry()))
//                .collect(Collectors.toMap(Function.identity(), it -> distanceCalculatorHaversine.calculateDistance(it.getCoordinates(), coordinates)))
//                .entrySet()
//                .stream()
////                .filter(earthquakeDoubleEntry -> e)
//                .sorted(Map.Entry.comparingByValue())
//                .limit(10)
//                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldDistance, newDistance) -> oldDistance, LinkedHashMap::new));
        result3.forEach((it, it2) -> System.out.println(it.toString() + " " + it2.toString()));

    }
}

