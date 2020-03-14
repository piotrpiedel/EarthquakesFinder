package service;

import java.util.Scanner;

public class ReadUserInput {

    private Scanner scanner;
    private String latitudeInput;
    private String longitudeInput;

    public ReadUserInput(Scanner scanner) {
        this.scanner = scanner;
    }

    public void readUserInput() {
        System.out.println("\n");
        System.out.println("Enter coordinates to find ten nearest earthquakes from last month in order latitude, longitude");
        System.out.println("Enter latitude from range [-90.0, 90.0]");
        latitudeInput = scanner.nextLine();
        System.out.println("Enter longitude from range [-180.0,180.0]");
        longitudeInput = scanner.nextLine();
    }

    public String getLatitudeInput() {
        return latitudeInput;
    }

    public String getLongitudeInput() {
        return longitudeInput;
    }
}
