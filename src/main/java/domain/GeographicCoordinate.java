package domain;

import java.util.Objects;

public abstract class GeographicCoordinate {

    private double value;

    protected GeographicCoordinate(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public static double checkValueWithGivenRangeAndParseValueToDouble(String line, double lowestValue, double highestValue) {
        if (isNotNullBlankOrEmpty(line)) {
            throw new IllegalArgumentException("Values can't be blank!");
        } else {
            try {
                double coordinate = Double.parseDouble(line);
                if (isValueInCorrectRange(lowestValue, highestValue, coordinate)) {
                    return coordinate;
                } else {
                    throw new IllegalArgumentException("Value can have range from: " + lowestValue + " to: " + highestValue + "!");
                }
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Please enter correct value!");
            }
        }
    }

    private static boolean isValueInCorrectRange(double lowestValue, double highestValue, double coordinate) {
        return coordinate >= lowestValue && coordinate <= highestValue;
    }

    private static boolean isNotNullBlankOrEmpty(String line) {
        return line == null || line.length() == 0 || line.chars().allMatch(Character::isWhitespace);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GeographicCoordinate that = (GeographicCoordinate) o;
        return Double.compare(that.value, value) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
