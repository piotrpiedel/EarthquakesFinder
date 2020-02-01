package service;

import client.EarthquakesApiClient;
import client.MonthAllEarthquakes;
import domain.Coordinates;
import domain.EarthquakePlaceToCoordinates;
import util.EarthquakesUtil;
import util.MapUtil;

import java.util.List;
import java.util.Map;

import static util.EarthquakesUtil.filterEarthquakesWithCoordinatesDuplicates;
import static util.EarthquakesUtil.mapFeaturesToEarthquakePlaceToCoordinatesList;

public class EarthquakesService {

    EarthquakesApiClient earthquakesApiClient = new MonthAllEarthquakes();

    public Map<EarthquakePlaceToCoordinates, Double> getNearestEarthquakesSortedByDistanceDistinct(Coordinates coordinates, int earthquakesToDisplay) {
        List<EarthquakePlaceToCoordinates> earthquakePlaceToCoordinates = mapFeaturesToEarthquakePlaceToCoordinatesList(earthquakesApiClient.getFeaturesFromEndpoint());

        List<EarthquakePlaceToCoordinates> filteredEarthquakes = filterEarthquakesWithCoordinatesDuplicates(earthquakePlaceToCoordinates);

        Map<EarthquakePlaceToCoordinates, Double> earthquakesSortedByDistance = MapUtil
                .sortByValue(EarthquakesUtil
                        .mapEarthquakesListToEarthQuakesToDistanceMap(filteredEarthquakes, coordinates));

        return MapUtil.getEntriesSortedByValue(earthquakesSortedByDistance, earthquakesToDisplay);
    }

    public String getPrintableNearbyEarthquakes(Coordinates coordinates) {
        StringBuilder stringBuilder = new StringBuilder();
        Map<EarthquakePlaceToCoordinates, Double> earthquakes = getNearestEarthquakesSortedByDistanceDistinct(coordinates, 10);
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
