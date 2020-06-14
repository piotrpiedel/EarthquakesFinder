package infrastructure.transformer;

import domain.model.CoordinatesValues;
import infrastructure.exception.IncorrectCoordinateValueException;
import infrastructure.exception.IncorrectCoordinateValueRangeException;
import org.apache.log4j.Logger;

public class UserInputToCoordinates {

    private static final Logger logger = Logger.getLogger(UserInputToCoordinates.class);

    public double checkLatitudeRangeAndParseValue(String line) {
        try {
            return checkValueWithGivenRangeAndParseValueToDouble(
                    line,
                    CoordinatesValues.LOWEST_LATITUDE.getValue(),
                    CoordinatesValues.HIGHEST_LATITUDE.getValue());
        } catch (IncorrectCoordinateValueRangeException | IncorrectCoordinateValueException e) {
            logger.error("Given latitude is incorrect", e);
        }
        return 0d;
    }

    public double checkLongitudeRangeAndParseValue(String line) {
        try {
            return checkValueWithGivenRangeAndParseValueToDouble(
                    line,
                    CoordinatesValues.LOWEST_LONGITUDE.getValue(),
                    CoordinatesValues.HIGHEST_LONGITUDE.getValue());
        } catch (IncorrectCoordinateValueRangeException | IncorrectCoordinateValueException e) {
            logger.error("Given longitude is incorrect", e);
        }
        return 0d;
    }

    private double checkValueWithGivenRangeAndParseValueToDouble(
            String line, double lowestValue, double highestValue)
            throws IncorrectCoordinateValueRangeException, IncorrectCoordinateValueException {
        if (isNotNullBlankOrEmpty(line)) {
            throw new IllegalArgumentException("Values can't be blank!");
        }
        try {
            double coordinate = Double.parseDouble(line);
            if (isValueInCorrectRange(lowestValue, highestValue, coordinate)) {
                return coordinate;
            }
            throw new IncorrectCoordinateValueRangeException(
                    "Value can have range from: " + lowestValue + " to: "
                            + highestValue);
        } catch (NumberFormatException e) {
            throw new IncorrectCoordinateValueException("Please enter correct value!", e);
        }
    }

    private boolean isValueInCorrectRange(
            double lowestValue, double highestValue, double coordinate) {
        return coordinate >= lowestValue && coordinate <= highestValue;
    }

    private boolean isNotNullBlankOrEmpty(String line) {
        return line == null || line.isEmpty() || line.chars().allMatch(Character::isWhitespace);
    }
}
