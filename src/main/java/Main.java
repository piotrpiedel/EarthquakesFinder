import client.MonthAllEarthquakes;
import distancecalc.DistanceCalculatorHaversine;
import domain.Coordinates;
import domain.Latitude;
import domain.Longitude;
import service.EarthquakesService;
import service.PrintNearbyEarthquakes;
import service.ReadUserInput;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        run();
    }

    private static void run() {
        final int earthQuakesToDisplay = 10;
        EarthquakesService earthquakesService = new EarthquakesService(new DistanceCalculatorHaversine(), new MonthAllEarthquakes());
        ReadUserInput readUserInput = new ReadUserInput(new Scanner(System.in));
        PrintNearbyEarthquakes printNearbyEarthquakes = new PrintNearbyEarthquakes();

        while (true) {
            readUserInput.readUserInput();
            try {
                Latitude latitude = Latitude.parseValueToLatitude(readUserInput.getLatitudeInput());
                Longitude longitude = Longitude.parseValueToLongitude(readUserInput.getLongitudeInput());
                System.out.println("Ten nearest earthquakes from last month to given coordinates");

                System.out.println(printNearbyEarthquakes.getPrintableNearbyEarthquakes(
                        earthquakesService
                                .getNearestEarthquakesSortedByDistanceDistinct(
                                        new Coordinates(latitude, longitude), earthQuakesToDisplay)));

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

