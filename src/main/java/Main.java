import client.EarthquakesApiClient;
import client.MonthAllEarthquakes;
import domain.Coordinates;
import domain.EarthquakePlaceToCoordinates;
import service.EarthquakesService;
import util.EarthquakesUtil;
import util.MapUtil;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static util.CoordinatesParser.parseLatitude;
import static util.CoordinatesParser.parseLongitude;
import static util.EarthquakesUtil.filterEarthquakesWithCoordinatesDuplicates;
import static util.EarthquakesUtil.mapFeaturesToEarthquakePlaceToCoordinatesList;


//Latitude : max/min +90 to -90
//
//Longitude : max/min +180 to -180

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        run();
    }

    private static void run() {
        EarthquakesService earthquakesService = new EarthquakesService();

        while (true) {
            System.out.println("Please enter latitude and longitude to get nearest earthquakes (press enter after each value)");
            System.out.println("Note: latitude should be in [-90.0, 90.0], longitude should be in [-180.0,180.0]");
            String line = scanner.nextLine();
            try {
                double latitude = parseLatitude(line);
                double longitude = parseLongitude(scanner.nextLine());
                System.out.println("Searching for nearest to point (" + latitude + ", " + longitude + ") earthquakes...");

                System.out.println(earthquakesService.getPrintableNearbyEarthquakes(new Coordinates(latitude, longitude)));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Something went wrong, please try again...");
            }
        }
    }
}

