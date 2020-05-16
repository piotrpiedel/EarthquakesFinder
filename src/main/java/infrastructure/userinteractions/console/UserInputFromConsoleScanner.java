package infrastructure.userinteractions.console;

import infrastructure.userinteractions.UserInputScanner;

import java.util.Scanner;

public class UserInputFromConsoleScanner implements UserInputScanner {

    private final Scanner scanner;

    public UserInputFromConsoleScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public String readUserInput() {
        return scanner.nextLine();
    }
}
