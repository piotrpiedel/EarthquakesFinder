package infrastructure.transformer;

import domain.model.CoordinatesRanges;
import infrastructure.exception.IncorrectCoordinateValueException;
import infrastructure.exception.IncorrectCoordinateValueRangeException;
import org.apache.log4j.Logger;

public class UserInputToCoordinates {

    private static final Logger logger = Logger.getLogger(UserInputToCoordinates.class);

    public double validateLatitudeRangeAndParseValue(String line) {
        try {
            return validateValueWithGivenRangeAndParseValueToDouble(
                    line,
                    CoordinatesRanges.LATITUDE);
        } catch (IncorrectCoordinateValueRangeException | IncorrectCoordinateValueException e) {
            logger.error("Given latitude is incorrect", e);
        }
        return 0d;
    }

    public double validateLongitudeAndParseValue(String line) {
        try {
            return validateValueWithGivenRangeAndParseValueToDouble(
                    line,
                    CoordinatesRanges.LONGITUDE);
        } catch (IncorrectCoordinateValueRangeException | IncorrectCoordinateValueException e) {
            logger.error("Given longitude is incorrect", e);
        }
        return 0d;
    }

    private double validateValueWithGivenRangeAndParseValueToDouble(
            String line,
            CoordinatesRanges coordinatesRanges)
            throws IncorrectCoordinateValueRangeException, IncorrectCoordinateValueException {
        if (isNotNullBlankOrEmpty(line)) {
            throw new IllegalArgumentException("Values can't be blank!");
        }
        try {
            double coordinate = Double.parseDouble(line);
            if (isValueInCorrectRange(coordinate, coordinatesRanges)) {
                return coordinate;
            }
            throw new IncorrectCoordinateValueRangeException(
                    "Value can have range from: " + coordinatesRanges.getLowestValue() + " to: "
                            + coordinatesRanges.getHighestValue());
        } catch (NumberFormatException e) {
            throw new IncorrectCoordinateValueException("Please enter correct value!", e);
        }
    }

    private boolean isValueInCorrectRange(double coordinate, CoordinatesRanges coordinatesRanges) {
        return coordinate >= coordinatesRanges.getLowestValue() && coordinate <= coordinatesRanges
                .getHighestValue();
    }

    private boolean isNotNullBlankOrEmpty(String line) {
        return line == null || line.isEmpty() || line.chars().allMatch(Character::isWhitespace);
    }
}
