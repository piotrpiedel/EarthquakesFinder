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
    private final DistanceCalculator distanceCalculator;
    private final EarthquakesApiClient earthquakesApiClient;

    public EarthquakesService(DistanceCalculator distanceCalculator, EarthquakesApiClient earthquakesApiClient) {
        this.distanceCalculator = distanceCalculator;
        this.earthquakesApiClient = earthquakesApiClient;
    }

    public Map<EarthquakeBasicInfo, Double> getNearestEarthquakesSortedByDistanceDistinct(Coordinates coordinates, int earthquakesToDisplay) {
        List<EarthquakeBasicInfo> earthquakeBasicInfos = EarthquakeBasicInfo.mapFeaturesToEarthquakeBasicInfos(earthquakesApiClient.getFeaturesFromEndpoint());

        List<EarthquakeBasicInfo> filteredEarthquakes = EarthquakeBasicInfo.filterEarthquakesWithDuplicatedCoordinates(earthquakeBasicInfos);

        Map<EarthquakeBasicInfo, Double> earthquakesSortedByDistance = sortByValue(mapEarthquakesToEarthquakesBasicInfosToDistance(filteredEarthquakes, coordinates));

        return getEntriesSortedByValue(earthquakesSortedByDistance, earthquakesToDisplay);
    }

    public Map<EarthquakeBasicInfo, Double> mapEarthquakesToEarthquakesBasicInfosToDistance(List<EarthquakeBasicInfo> earthquakeBasicInfos, Coordinates coordinatesToMeasureDistanceFrom) {
        return earthquakeBasicInfos
                .stream()
                .collect(Collectors.toMap(Function.identity(), it -> distanceCalculator.calculateDistance(it.getCoordinates(), coordinatesToMeasureDistanceFrom)));
    }


}