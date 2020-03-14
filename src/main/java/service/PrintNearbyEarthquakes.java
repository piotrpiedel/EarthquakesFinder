package service;

import domain.EarthquakeBasicInfo;

import java.util.Map;

public class PrintNearbyEarthquakes {

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
