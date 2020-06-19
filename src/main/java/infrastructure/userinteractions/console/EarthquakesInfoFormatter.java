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
            appendEarthquakePlaceToDistance(stringBuilder, earthquake);
            if (!isFirstLineOfOutput(stringBuilder)) {
                appendNewLine(stringBuilder);
            }
        });
        return stringBuilder.toString();
    }

    private static void appendEarthquakePlaceToDistance(
            StringBuilder stringBuilder,
            EarthquakeBasicInfoWithDistanceToIndicatedPoint earthquake) {
        stringBuilder
                .append(earthquake.getEarthquakeBasicInfo().getPlace())
                .append(" || ")
                .append(earthquake.getDistanceToEarthquake());
    }

    private static boolean isFirstLineOfOutput(StringBuilder stringBuilder) {
        return stringBuilder.toString().isEmpty();
    }

    private static void appendNewLine(StringBuilder stringBuilder) {
        stringBuilder.append('\n');
    }

}
