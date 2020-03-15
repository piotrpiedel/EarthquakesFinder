package service;

import domain.EarthquakeBasicInfoWithDistanceToPoint;

import java.util.List;

public class EarthquakesInfoFormatter {

    public static String formatEarthquakesToPrintableOutput(List<EarthquakeBasicInfoWithDistanceToPoint> earthquakes) {
        StringBuilder stringBuilder = new StringBuilder();
        earthquakes.forEach((earthquake) -> {
            if (stringBuilder.toString().isEmpty()) {
                stringBuilder
                        .append(earthquake.getEarthquakeBasicInfo().getPlace())
                        .append(" || ")
                        .append(earthquake.getDistanceToEarthquake().toString());
            } else {
                stringBuilder.append("\n")
                        .append(earthquake.getEarthquakeBasicInfo().getPlace()).
                        append(" || ")
                        .append(earthquake.getDistanceToEarthquake().toString());
            }
        });
        return stringBuilder.toString();
    }
}
