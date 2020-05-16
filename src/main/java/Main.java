import application.distancecalc.HaversineDistanceCalculator;
import application.service.EarthquakesService;
import domain.model.Coordinates;
import domain.model.EarthquakeBasicInfoWithDistanceToIndicatedPoint;
import domain.model.Latitude;
import domain.model.Longitude;
import infrastructure.client.EarthquakesApiClient;
import infrastructure.exception.IncorrectEndpoint;
import infrastructure.transformer.FeatureToEarthquakeBasicInfoTransformer;
import infrastructure.transformer.UserInputToCoordinates;
import infrastructure.userinteractions.RequestForUserInputPrinter;
import infrastructure.userinteractions.UserInputScanner;
import infrastructure.userinteractions.console.EarthquakesPrinterToConsole;
import infrastructure.userinteractions.console.RequestForUserInputPrinterToConsole;
import infrastructure.userinteractions.console.UserInputFromConsoleScanner;

import java.util.List;
import java.util.Scanner;

public class Main {

    private static final UserInputScanner USER_INPUT_SCANNER = new UserInputFromConsoleScanner(new Scanner(System.in));
    private static final RequestForUserInputPrinter REQUEST_FOR_USER_INPUT_PRINTER = new RequestForUserInputPrinterToConsole();
    private static final EarthquakesPrinterToConsole EARTHQUAKES_PRINTER_TO_CONSOLE = new EarthquakesPrinterToConsole();
    private static final UserInputToCoordinates USER_INPUT_TO_COORDINATES = new UserInputToCoordinates();

    public static void main(String[] args) {
        run();
    }

    private static void run() {

        EarthquakesService earthquakesService = new EarthquakesService(new HaversineDistanceCalculator(),
                new EarthquakesApiClient(), new FeatureToEarthquakeBasicInfoTransformer());

        while (true) {
            Latitude latitude;
            Longitude longitude;
            int earthQuakesNumberToDisplay = 0;
            latitude = getLatitudeFromUser();
            longitude = getLongitudeFromUser();
            earthQuakesNumberToDisplay = getEarthQuakesNumberToDisplay();

            List<EarthquakeBasicInfoWithDistanceToIndicatedPoint> nearestEarthquakesSortedByDistanceDistinct = null;
            try {
                nearestEarthquakesSortedByDistanceDistinct = earthquakesService
                        .getNearestEarthquakesSortedByDistanceDistinct(new Coordinates(longitude, latitude), earthQuakesNumberToDisplay);

            } catch (IncorrectEndpoint e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }

            EARTHQUAKES_PRINTER_TO_CONSOLE.printNearbyEarthquakes(nearestEarthquakesSortedByDistanceDistinct);
        }
    }

    private static Latitude getLatitudeFromUser() {
        REQUEST_FOR_USER_INPUT_PRINTER.printRequestForLatitude();
        String latitudeInput = USER_INPUT_SCANNER.readUserInput();

        return new Latitude(USER_INPUT_TO_COORDINATES.checkLatitudeRangeAndParseValue(latitudeInput));
    }

    private static Longitude getLongitudeFromUser() {
        REQUEST_FOR_USER_INPUT_PRINTER.printRequestForLongitude();
        String longitudeInput = USER_INPUT_SCANNER.readUserInput();

        return new Longitude(USER_INPUT_TO_COORDINATES.checkLongitudeRangeAndParseValue(longitudeInput));
    }

    private static int getEarthQuakesNumberToDisplay() {
        REQUEST_FOR_USER_INPUT_PRINTER.printRequestForEarthquakesNumberToDisplay();
        try {
            return Integer.parseInt(USER_INPUT_SCANNER.readUserInput());
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }
}

