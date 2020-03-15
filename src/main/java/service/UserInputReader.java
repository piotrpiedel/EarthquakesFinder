package service;

import java.util.Scanner;

public class UserInputReader {

    private Scanner scanner;

    public UserInputReader(Scanner scanner) {
        this.scanner = scanner;
    }

    public String printRequestForLatitudeAndReturnInput() {
        return printRequestToUserAndReadInput("Enter latitude from range [-90.0, 90.0]");
    }

    public String printRequestForLongitudeAndReturnInput() {
        return printRequestToUserAndReadInput("Enter longitude from range [-180.0,180.0]");
    }

    private String printRequestToUserAndReadInput(String requestDisplayedToUser) {
        System.out.println("\n");
        System.out.println(requestDisplayedToUser);
        return scanner.nextLine();
    }
}
