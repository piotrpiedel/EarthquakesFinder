package infrastructure.transformer;

import domain.coordinates.CoordinatesRanges;
import infrastructure.exception.IncorrectCoordinateValueException;
import infrastructure.exception.IncorrectCoordinateValueRangeException;

public class CoordinatesRangeValidator {

    public double validateValueWithLatitudeRangeAndConvertToDouble(String line)
            throws IncorrectCoordinateValueRangeException, IncorrectCoordinateValueException {
        return validateValueWithGivenRangeAndConvertToDouble(
                line,
                CoordinatesRanges.LATITUDE);

    }

    public double validateValueWithLongitudeRangeAndConvertToDouble(String line)
            throws IncorrectCoordinateValueRangeException, IncorrectCoordinateValueException {
        return validateValueWithGivenRangeAndConvertToDouble(
                line,
                CoordinatesRanges.LONGITUDE);
    }

    private double validateValueWithGivenRangeAndConvertToDouble(
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
