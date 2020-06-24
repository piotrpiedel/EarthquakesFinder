import application.distancecalc.HaversineDistanceCalculator;
import application.service.EarthquakesService;
import domain.coordinates.Coordinates;
import domain.coordinates.Latitude;
import domain.coordinates.Longitude;
import domain.earthquake.EarthquakeBasicInfoWithDistanceToIndicatedPoint;
import infrastructure.client.EarthquakesApiClient;
import infrastructure.exception.IncorrectCoordinateValueException;
import infrastructure.exception.IncorrectCoordinateValueRangeException;
import infrastructure.exception.IncorrectEndpointException;
import infrastructure.transformer.CoordinatesRangeValidator;
import infrastructure.transformer.FeatureToEarthquakeBasicInfoTransformer;
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
    private static final CoordinatesRangeValidator COORDINATES_RANGE_VALIDATOR = new CoordinatesRangeValidator();

    public static void main(String[] args) {
        run();
    }

    private static void run() {

        EarthquakesService earthquakesService = new EarthquakesService(
                new HaversineDistanceCalculator(),
                new EarthquakesApiClient(), new FeatureToEarthquakeBasicInfoTransformer());

        String userInputToExitProgram;
        do {
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
                    .printEarthquakes(nearestEarthquakesSortedByDistanceDistinct);

            userInputToExitProgram = printRequestToUserHowToExitProgramAndReadInput();
        }
        while (isNotUserExitingProgram(userInputToExitProgram));
    }

    private static boolean isNotUserExitingProgram(String userInputToExitProgram) {
        return !"q".equalsIgnoreCase(userInputToExitProgram);
    }

    private static Latitude getLatitudeFromUser() {
        boolean userProvidedCorrectInput = false;
        double validatedValue = 0;
        do {
            REQUEST_FOR_USER_INPUT_PRINTER.printRequestForLatitude();
            String latitudeInput = USER_INPUT_SCANNER.readNext();
            try {
                validatedValue = COORDINATES_RANGE_VALIDATOR
                        .validateValueWithLatitudeRangeAndConvertToDouble(latitudeInput);
                userProvidedCorrectInput = true;
            } catch (IncorrectCoordinateValueRangeException | IncorrectCoordinateValueException e) {
                System.out.println("Given latitude is incorrect");
            }
        } while (!userProvidedCorrectInput);
        return new Latitude(validatedValue);
    }

    private static Longitude getLongitudeFromUser() {
        boolean userProvidedCorrectInput = false;
        double validatedValue = 0;
        do {
            REQUEST_FOR_USER_INPUT_PRINTER.printRequestForLongitude();
            String longitudeInput = USER_INPUT_SCANNER.readNext();
            try {
                validatedValue = COORDINATES_RANGE_VALIDATOR
                        .validateValueWithLongitudeRangeAndConvertToDouble(longitudeInput);
                userProvidedCorrectInput = true;
            } catch (IncorrectCoordinateValueRangeException | IncorrectCoordinateValueException e) {
                System.out.println("Given longitude is incorrect");
            }
        } while (!userProvidedCorrectInput);
        return new Longitude(validatedValue);
    }

    private static int getEarthQuakesNumberToDisplay() {
        boolean userProvidedCorrectInput = false;
        int validatedValue = 0;
        do {
            REQUEST_FOR_USER_INPUT_PRINTER.printRequestForEarthquakesNumberToDisplay();
            String earthquakesNumber = USER_INPUT_SCANNER.readNext();
            try {
                validatedValue = Integer.parseInt(earthquakesNumber);
                userProvidedCorrectInput = true;
            } catch (NumberFormatException e) {
                System.out.println("Given earthquakes to display number is incorrect");
            }
        } while (!userProvidedCorrectInput);
        return validatedValue;
    }

    private static String printRequestToUserHowToExitProgramAndReadInput() {
        REQUEST_FOR_USER_INPUT_PRINTER.printRequestToUserHowToExitProgram();
        return USER_INPUT_SCANNER.readNext();
    }

}

