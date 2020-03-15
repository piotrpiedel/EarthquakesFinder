package service;

import client.EarthquakesApiClient;
import distancecalc.DistanceCalculator;
import domain.Coordinates;
import domain.EarthquakeBasicInfo;
import domain.EarthquakeBasicInfoWithDistanceToPoint;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class EarthquakesService {
    private final DistanceCalculator distanceCalculator;
    private final EarthquakesApiClient earthquakesApiClient;

    public EarthquakesService(DistanceCalculator distanceCalculator, EarthquakesApiClient earthquakesApiClient) {
        this.distanceCalculator = distanceCalculator;
        this.earthquakesApiClient = earthquakesApiClient;
    }

    public List<EarthquakeBasicInfoWithDistanceToPoint> getNearestEarthquakesSortedByDistanceDistinct(Coordinates coordinates, int earthquakesToDisplay) throws IOException {
        List<EarthquakeBasicInfo> earthquakeBasicInfos = EarthquakeBasicInfo.mapFeaturesToEarthquakeBasicInfos(earthquakesApiClient.getFeaturesFromEndpoint());

        List<EarthquakeBasicInfo> filteredEarthquakes = EarthquakeBasicInfo.filterEarthquakesWithDuplicatedCoordinates(earthquakeBasicInfos);

        List<EarthquakeBasicInfoWithDistanceToPoint> earthquakeBasicInfosWithDistanceToPoints = calculateEarthquakeDistanceToCoordinates(filteredEarthquakes, coordinates);

        Collections.sort(earthquakeBasicInfosWithDistanceToPoints);

        return earthquakeBasicInfosWithDistanceToPoints
                .stream()
                .limit(earthquakesToDisplay)
                .collect(Collectors.toList());
    }

    public List<EarthquakeBasicInfoWithDistanceToPoint> calculateEarthquakeDistanceToCoordinates(List<EarthquakeBasicInfo> earthquakeBasicInfos, Coordinates coordinatesToMeasureDistanceTo) {
        return earthquakeBasicInfos.stream().map(earthquakeBasicInfo ->
                new EarthquakeBasicInfoWithDistanceToPoint(earthquakeBasicInfo, distanceCalculator.calculateDistance(earthquakeBasicInfo.getCoordinates(), coordinatesToMeasureDistanceTo)))
                .collect(Collectors.toList());

    }


}