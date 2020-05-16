package infrastructure.transformer;

import domain.model.CoordinatesValues;

public class UserInputToCoordinates {

    public double checkLatitudeRangeAndParseValue(String line) {
        return checkValueWithGivenRangeAndParseValueToDouble(line,
                CoordinatesValues.LOWEST_LATITUDE.getValue(),
                CoordinatesValues.HIGHEST_LATITUDE.getValue());
    }

    public double checkLongitudeRangeAndParseValue(String line) {
        return checkValueWithGivenRangeAndParseValueToDouble(line,
                CoordinatesValues.LOWEST_LONGITUDE.getValue(),
                CoordinatesValues.HIGHEST_LONGITUDE.getValue());

    }

    private double checkValueWithGivenRangeAndParseValueToDouble(String line, double lowestValue, double highestValue) {
        if (isNotNullBlankOrEmpty(line)) {
            throw new IllegalArgumentException("Values can't be blank!");
        } else {
            try {
                double coordinate = Double.parseDouble(line);
                if (isValueInCorrectRange(lowestValue, highestValue, coordinate)) {
                    return coordinate;
                } else {
                    System.out.println("Value can have range from: " + lowestValue + " to: " + highestValue + "!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter correct value!" + e.getMessage());
            }
        }
        return 0.0;
    }

    private boolean isValueInCorrectRange(double lowestValue, double highestValue, double coordinate) {
        return coordinate >= lowestValue && coordinate <= highestValue;
    }

    private boolean isNotNullBlankOrEmpty(String line) {
        return line == null || line.length() == 0 || line.chars().allMatch(Character::isWhitespace);
    }
}
