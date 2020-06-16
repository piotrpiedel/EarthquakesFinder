package infrastructure.userinteractions.console;

import infrastructure.userinteractions.RequestForUserInputPrinter;

public class RequestForUserInputPrinterToConsole implements RequestForUserInputPrinter {

    @Override
    public void printRequestForLatitude() {
        printRequestToUser("Enter latitude from range [-90.0, 90.0]");
    }

    @Override
    public void printRequestForLongitude() {
        printRequestToUser("Enter longitude from range [-180.0,180.0]");
    }

    @Override
    public void printRequestForEarthquakesNumberToDisplay() {
        printRequestToUser("Enter earthquakes to display");
    }

    private void printRequestToUser(String requestDisplayedToUser) {
        System.out.println(requestDisplayedToUser);
    }

    @Override
    public void printRequestToUserHowToExitProgram() {
        printRequestToUser(
                "Write q to exit program and press enter. Leave empty and press enter to continue");
    }
}
