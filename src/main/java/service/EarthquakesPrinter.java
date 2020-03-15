package service;

import domain.EarthquakeBasicInfoWithDistanceToPoint;

import java.util.List;

import static service.EarthquakesInfoFormatter.formatEarthquakesToPrintableOutput;

public class EarthquakesPrinter {

    public void printNearbyEarthquakesToConsole(List<EarthquakeBasicInfoWithDistanceToPoint> nearestDistinctEarthquakesSortedByDistance) {
        System.out.println("Ten nearest earthquakes from last month to given coordinates");
        System.out.println(formatEarthquakesToPrintableOutput(nearestDistinctEarthquakesSortedByDistance));
    }
}
