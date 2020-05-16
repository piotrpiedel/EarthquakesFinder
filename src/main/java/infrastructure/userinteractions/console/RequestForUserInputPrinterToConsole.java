package infrastructure.userinteractions.console;

import infrastructure.userinteractions.RequestForUserInputPrinter;

public class RequestForUserInputPrinterToConsole implements RequestForUserInputPrinter {

    @Override
    public void printRequestForLatitude() {
        printRequestToUserAndReadInput("Enter latitude from range [-90.0, 90.0]");
    }

    @Override
    public void printRequestForLongitude() {
        printRequestToUserAndReadInput("Enter longitude from range [-180.0,180.0]");
    }

    @Override
    public void printRequestForEarthquakesNumberToDisplay() {
        printRequestToUserAndReadInput("Enter earthquakes to display");
    }

    private void printRequestToUserAndReadInput(String requestDisplayedToUser) {
        System.out.println("\n");
        System.out.println(requestDisplayedToUser);
    }
}
