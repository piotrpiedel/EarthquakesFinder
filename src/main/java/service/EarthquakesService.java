package service;

import client.EarthquakesApiClient;
import distancecalc.DistanceCalculator;
import domain.Coordinates;
import domain.EarthquakeBasicInfo;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static util.MapUtil.getEntriesSortedByValue;
import static util.MapUtil.sortByValue;

public class EarthquakesService {
    private DistanceCalculator distanceCalculator;
    private EarthquakesApiClient earthquakesApiClient;

    public EarthquakesService(DistanceCalculator distanceCalculator, EarthquakesApiClient earthquakesApiClient) {
        this.distanceCalculator = distanceCalculator;
        this.earthquakesApiClient = earthquakesApiClient;
    }

    public Map<EarthquakeBasicInfo, Double> getNearestEarthquakesSortedByDistanceDistinct(Coordinates coordinates, int earthquakesToDisplay) {
        List<EarthquakeBasicInfo> earthquakePlaceToCoordinates = EarthquakeBasicInfo.mapFeaturesToEarthquakePlaceToCoordinatesList(earthquakesApiClient.getFeaturesFromEndpoint());

        List<EarthquakeBasicInfo> filteredEarthquakes = EarthquakeBasicInfo.filterEarthquakesWithCoordinatesDuplicates(earthquakePlaceToCoordinates);

        Map<EarthquakeBasicInfo, Double> earthquakesSortedByDistance = sortByValue(mapEarthquakesListToEarthQuakesToDistanceMap(filteredEarthquakes, coordinates));

        return getEntriesSortedByValue(earthquakesSortedByDistance, earthquakesToDisplay);
    }

    public Map<EarthquakeBasicInfo, Double> mapEarthquakesListToEarthQuakesToDistanceMap(List<EarthquakeBasicInfo> earthquakePlaceToCoordinates, Coordinates coordinatesToMeasureDistanceFrom) {
        return earthquakePlaceToCoordinates
                .stream()
                .collect(Collectors.toMap(Function.identity(), it -> distanceCalculator.calculateDistance(it.getCoordinates(), coordinatesToMeasureDistanceFrom)));
    }

    public String getPrintableNearbyEarthquakes(Map<EarthquakeBasicInfo, Double> earthquakes) {
        StringBuilder stringBuilder = new StringBuilder();
        earthquakes.forEach((earthquake, distance) -> {
            if (stringBuilder.toString().isEmpty()) {
                stringBuilder.append(earthquake.getPlace()).append(" || ").append(distance);
            } else {
                stringBuilder.append("\n").append(earthquake.getPlace()).append(" || ").append(distance);
            }
        });
        return stringBuilder.toString();
    }


}
