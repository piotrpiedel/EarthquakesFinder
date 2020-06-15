import application.distancecalc.HaversineDistanceCalculator;
import application.service.EarthquakesService;
import domain.model.Coordinates;
import domain.model.EarthquakeBasicInfoWithDistanceToIndicatedPoint;
import domain.model.Latitude;
import domain.model.Longitude;
import infrastructure.client.EarthquakesApiClient;
import infrastructure.exception.IncorrectEndpointException;
import infrastructure.transformer.FeatureToEarthquakeBasicInfoTransformer;
import infrastructure.transformer.UserInputToCoordinates;
import infrastructure.userinteractions.RequestForUserInputPrinter;
import infrastructure.userinteractions.UserInputScanner;
import infrastructure.userinteractions.console.EarthquakesPrinterToConsole;
import infrastructure.userinteractions.console.RequestForUserInputPrinterToConsole;
import infrastructure.userinteractions.console.UserInputFromConsoleScanner;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.Scanner;

public final class Main {

    private static final Logger logger = Logger.getLogger(Main.class);

    private static final UserInputScanner USER_INPUT_SCANNER = new UserInputFromConsoleScanner(
            new Scanner(System.in, "UTF-8"));
    private static final RequestForUserInputPrinter REQUEST_FOR_USER_INPUT_PRINTER = new RequestForUserInputPrinterToConsole();
    private static final EarthquakesPrinterToConsole EARTHQUAKES_PRINTER_TO_CONSOLE = new EarthquakesPrinterToConsole();
    private static final UserInputToCoordinates USER_INPUT_TO_COORDINATES = new UserInputToCoordinates();

    public static void main(String[] args) {
        run();
    }

    private static void run() {

        EarthquakesService earthquakesService = new EarthquakesService(
                new HaversineDistanceCalculator(),
                new EarthquakesApiClient(), new FeatureToEarthquakeBasicInfoTransformer());

        while (true) {
            Latitude latitude = getLatitudeFromUser();
            Longitude longitude = getLongitudeFromUser();
            int earthQuakesNumberToDisplay = getEarthQuakesNumberToDisplay();

            List<EarthquakeBasicInfoWithDistanceToIndicatedPoint> nearestEarthquakesSortedByDistanceDistinct = null;
            try {
                nearestEarthquakesSortedByDistanceDistinct = earthquakesService
                        .getNearestEarthquakesSortedByDistanceDistinct(
                                new Coordinates(longitude, latitude), earthQuakesNumberToDisplay);

            } catch (IncorrectEndpointException e) {
                logger.error("Incorrect endpoint", e);
            }

            EARTHQUAKES_PRINTER_TO_CONSOLE
                    .printNearbyEarthquakes(nearestEarthquakesSortedByDistanceDistinct);

            String userInputFromExitProgramRequest = printRequestToUserHowToExitProgramAndReadInput();
            if (shouldExitProgram(userInputFromExitProgramRequest)) {
                break;
            }
        }
    }

    private static Latitude getLatitudeFromUser() {
        REQUEST_FOR_USER_INPUT_PRINTER.printRequestForLatitude();
        String latitudeInput = USER_INPUT_SCANNER.readUserInput();

        return new Latitude(
                USER_INPUT_TO_COORDINATES
                        .validateLatitudeRangeAndParseValue(latitudeInput));
    }

    private static Longitude getLongitudeFromUser() {
        REQUEST_FOR_USER_INPUT_PRINTER.printRequestForLongitude();
        String longitudeInput = USER_INPUT_SCANNER.readUserInput();

        return new Longitude(
                USER_INPUT_TO_COORDINATES
                        .validateLongitudeAndParseValue(longitudeInput));
    }

    private static int getEarthQuakesNumberToDisplay() {
        REQUEST_FOR_USER_INPUT_PRINTER.printRequestForEarthquakesNumberToDisplay();
        try {
            return Integer.parseInt(USER_INPUT_SCANNER.readUserInput());
        } catch (NumberFormatException e) {
            logger.error("Given earthquakes to display number is incorrect", e);
        }
        return 0;
    }

    private static String printRequestToUserHowToExitProgramAndReadInput() {
        REQUEST_FOR_USER_INPUT_PRINTER.printRequestToUserHowToExitProgram();
        return USER_INPUT_SCANNER.readUserInput();
    }

    private static boolean shouldExitProgram(String userInputIfExitProgram) {
        return !userInputIfExitProgram.isEmpty() && "q".equalsIgnoreCase(userInputIfExitProgram);
    }

}

