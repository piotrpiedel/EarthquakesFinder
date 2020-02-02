import client.MonthAllEarthquakes;
import distancecalc.DistanceCalculatorHaversine;
import domain.Coordinates;
import domain.Latitude;
import domain.Longitude;
import service.EarthquakesService;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        run();
    }

    private static void run() {
        EarthquakesService earthquakesService = new EarthquakesService(new DistanceCalculatorHaversine(), new MonthAllEarthquakes());

        while (true) {
            System.out.println("\n");
            System.out.println("Enter coordinates to find ten nearest earthquakes from last month in order latitude, longitude");
            System.out.println("Enter latitude from range [-90.0, 90.0]");
            String latitudeInput = scanner.nextLine();
            System.out.println("Enter longitude from range [-180.0,180.0]");
            String longitudeInput = scanner.nextLine();
            try {
                Latitude latitude = new Latitude(latitudeInput);
                Longitude longitude = new Longitude(longitudeInput);
                System.out.println("Ten nearest earthquakes from last month to given coordinates");

                System.out.println(earthquakesService.getPrintableNearbyEarthquakes(
                        earthquakesService
                                .getNearestEarthquakesSortedByDistanceDistinct(
                                        new Coordinates(latitude, longitude), 10)));

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Something went wrong, please try again...");
            }
        }
    }
}

