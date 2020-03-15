import client.AllEarthquakesFromPastMonthApiClient;
import distancecalc.DistanceCalculatorHaversine;
import domain.Coordinates;
import domain.EarthquakeBasicInfoWithDistanceToPoint;
import domain.Latitude;
import domain.Longitude;
import service.EarthquakesService;
import service.EarthquakesPrinter;
import service.UserInputReader;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        run();
    }

    private static void run() {
        final int earthQuakesNumberToDisplay = 10;
        EarthquakesService earthquakesService = new EarthquakesService(new DistanceCalculatorHaversine(), new AllEarthquakesFromPastMonthApiClient());
        UserInputReader userInputReader = new UserInputReader(new Scanner(System.in));
        EarthquakesPrinter earthquakesPrinter = new EarthquakesPrinter();

        while (true) {

            String latitudeInput = userInputReader.printRequestForLatitudeAndReturnInput();
            String longitudeInput = userInputReader.printRequestForLongitudeAndReturnInput();

            try {
                Latitude latitude = Latitude.parseValueToLatitude(latitudeInput);
                Longitude longitude = Longitude.parseValueToLongitude(longitudeInput);

                List<EarthquakeBasicInfoWithDistanceToPoint> nearestEarthquakesSortedByDistanceDistinct = earthquakesService
                        .getNearestEarthquakesSortedByDistanceDistinct(new Coordinates(longitude, latitude), earthQuakesNumberToDisplay);

                earthquakesPrinter.printNearbyEarthquakesToConsole(nearestEarthquakesSortedByDistanceDistinct);

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

