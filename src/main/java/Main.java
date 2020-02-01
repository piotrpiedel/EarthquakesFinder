import domain.Coordinates;
import service.EarthquakesService;

import java.util.Scanner;

import static util.CoordinatesParser.parseLatitude;
import static util.CoordinatesParser.parseLongitude;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        run();
    }

    private static void run() {
        EarthquakesService earthquakesService = new EarthquakesService();

        while (true) {
            System.out.println("\n");
            System.out.println("Enter coordinates to find ten nearest earthquakes from last month in order latitude, longitude");
            System.out.println("Enter latitude from range [-90.0, 90.0]");
            String latitudeInput = scanner.nextLine();
            System.out.println("Enter longitude from range [-180.0,180.0]");
            String longitudeInput = scanner.nextLine();
            try {
                double latitude = parseLatitude(latitudeInput);
                double longitude = parseLongitude(longitudeInput);
                System.out.println("Ten nearest earthquakes from last month to given coordinates");
                System.out.println(earthquakesService.getPrintableNearbyEarthquakes(new Coordinates(latitude, longitude)));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Something went wrong, please try again...");
            }
        }
    }
}

