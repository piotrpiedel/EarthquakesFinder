package domain;

import java.util.Objects;

public abstract class GeographicCoordinate {

    protected double value;

    protected GeographicCoordinate(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public static double parse(String line, double lowestValue, double highestValue) {
        if (line == null || line.length() == 0 || line.chars().allMatch(Character::isWhitespace)) {
            throw new IllegalArgumentException("Values can't be blank!");
        } else {
            try {
                double coordinate = Double.parseDouble(line);
                if (coordinate < lowestValue || coordinate > highestValue) {
                    throw new IllegalArgumentException("Value can have range from: " + lowestValue + " to: " + highestValue + "!");
                } else {
                    return coordinate;
                }
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Please enter correct value!");
            }
        }
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
