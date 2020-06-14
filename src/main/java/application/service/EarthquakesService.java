package application.service;

import application.distancecalc.DistanceCalculator;
import domain.model.Coordinates;
import domain.model.EarthquakeBasicInfo;
import domain.model.EarthquakeBasicInfoWithDistanceToIndicatedPoint;
import infrastructure.client.EarthquakesApiClient;
import infrastructure.exception.IncorrectEndpointException;
import infrastructure.transformer.FeatureToEarthquakeBasicInfoTransformer;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class EarthquakesService {
    private final DistanceCalculator distanceCalculator;
    private final EarthquakesApiClient earthquakesApiClient;
    private final FeatureToEarthquakeBasicInfoTransformer featureToEarthquakeBasicInfoTransformer;

    public EarthquakesService(
            DistanceCalculator distanceCalculator,
            EarthquakesApiClient earthquakesApiClient,
            FeatureToEarthquakeBasicInfoTransformer featureToEarthquakeBasicInfoTransformer) {
        this.distanceCalculator = distanceCalculator;
        this.earthquakesApiClient = earthquakesApiClient;
        this.featureToEarthquakeBasicInfoTransformer = featureToEarthquakeBasicInfoTransformer;
    }

    public List<EarthquakeBasicInfoWithDistanceToIndicatedPoint> getNearestEarthquakesSortedByDistanceDistinct(
            Coordinates coordinates, int earthquakesToDisplay) throws IncorrectEndpointException {

        List<EarthquakeBasicInfo> earthquakeBasicInfos = featureToEarthquakeBasicInfoTransformer
                .map(earthquakesApiClient.getAllEarthquakesFromPastMonthApiClient());

        List<EarthquakeBasicInfo> filteredEarthquakes = filterEarthquakesWithDuplicatedCoordinates(
                earthquakeBasicInfos);

        List<EarthquakeBasicInfoWithDistanceToIndicatedPoint> earthquakeBasicInfosWithDistanceToPoints = calculateEarthquakeDistanceToCoordinates(
                filteredEarthquakes, coordinates);

        Collections.sort(earthquakeBasicInfosWithDistanceToPoints);

        return earthquakeBasicInfosWithDistanceToPoints
                .stream()
                .limit(earthquakesToDisplay)
                .collect(Collectors.toList());
    }

    public List<EarthquakeBasicInfoWithDistanceToIndicatedPoint> calculateEarthquakeDistanceToCoordinates(
            List<EarthquakeBasicInfo> earthquakeBasicInfos,
            Coordinates coordinatesToMeasureDistanceTo) {
        return earthquakeBasicInfos
                .stream()
                .map(earthquakeBasicInfo ->
                        new EarthquakeBasicInfoWithDistanceToIndicatedPoint(
                                earthquakeBasicInfo,
                                distanceCalculator.calculateDistance(
                                        earthquakeBasicInfo.getCoordinates(),
                                        coordinatesToMeasureDistanceTo)))
                .collect(Collectors.toList());
    }

    public List<EarthquakeBasicInfo> filterEarthquakesWithDuplicatedCoordinates(
            List<EarthquakeBasicInfo> earthquakeBasicInfoList) {
        Set<Coordinates> set = new HashSet<>();
        return earthquakeBasicInfoList
                .stream()
                .filter(p -> set.add(p.getCoordinates()))
                .collect(Collectors.toList());
    }
}