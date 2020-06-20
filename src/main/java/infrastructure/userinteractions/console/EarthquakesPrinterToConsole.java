package infrastructure.userinteractions.console;

import domain.model.EarthquakeBasicInfoWithDistanceToIndicatedPoint;
import infrastructure.userinteractions.EarthquakePrinter;

import java.util.List;

import static infrastructure.userinteractions.console.EarthquakesInfoFormatter.formatEarthquakesToConsolePrintableOutput;

public class EarthquakesPrinterToConsole implements EarthquakePrinter {

    @Override
    public void printEarthquakes(
            List<EarthquakeBasicInfoWithDistanceToIndicatedPoint> nearestDistinctEarthquakesSortedByDistance) {
        System.out.println("Ten nearest earthquakes from last month to given coordinates");
        System.out.println(
                "Magnitude - place (Direction from the nearest city, country) || Distance to coordinates");
        System.out.println(formatEarthquakesToConsolePrintableOutput(
                nearestDistinctEarthquakesSortedByDistance));
    }
}
