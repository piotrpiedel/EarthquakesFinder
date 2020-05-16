package infrastructure.userinteractions.console;

import domain.model.EarthquakeBasicInfoWithDistanceToIndicatedPoint;
import infrastructure.userinteractions.EarthquakePrinter;

import java.util.List;

import static infrastructure.userinteractions.console.EarthquakesInfoFormatter.formatEarthquakesToConsolePrintableOutput;


public class EarthquakesPrinterToConsole implements EarthquakePrinter {

    @Override
    public void printNearbyEarthquakes(List<EarthquakeBasicInfoWithDistanceToIndicatedPoint> nearestDistinctEarthquakesSortedByDistance) {
        System.out.println("Ten nearest earthquakes from last month to given coordinates");
        System.out.println(formatEarthquakesToConsolePrintableOutput(nearestDistinctEarthquakesSortedByDistance));
    }
}
