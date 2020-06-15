package infrastructure.userinteractions.console;

import domain.model.EarthquakeBasicInfoWithDistanceToIndicatedPoint;
import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class EarthquakesInfoFormatter {

    public static String formatEarthquakesToConsolePrintableOutput(
            List<EarthquakeBasicInfoWithDistanceToIndicatedPoint> earthquakes) {
        StringBuilder stringBuilder = new StringBuilder();
        earthquakes.forEach(earthquake -> {
            if (stringBuilder.toString().isEmpty()) {
                stringBuilder
                        .append(earthquake.getEarthquakeBasicInfo().getPlace())
                        .append(" || ")
                        .append(earthquake.getDistanceToEarthquake());
            } else {
                stringBuilder.append('\n')
                        .append(earthquake.getEarthquakeBasicInfo().getPlace()).
                        append(" || ")
                        .append(earthquake.getDistanceToEarthquake());
            }
        });
        return stringBuilder.toString();
    }
}
