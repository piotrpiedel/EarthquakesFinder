package domain;

import java.util.Objects;

public abstract class GeographicCoordinate {

    protected abstract double getLowestValue();

    protected abstract double getHighestValue();

    protected double value;

    protected GeographicCoordinate(double value) {
        this.value = value;
    }

    protected GeographicCoordinate(String value) {
        this.value = parse(value);
    }

    public double getValue() {
        return value;
    }

    public double parse(String line) {
        if (line == null || line.length() == 0 || line.chars().allMatch(Character::isWhitespace)) {
            throw new IllegalArgumentException("Values can't be blank!");
        } else {
            try {
                double coordinate = Double.parseDouble(line);
                if (coordinate < getLowestValue() || coordinate > getHighestValue()) {
                    throw new IllegalArgumentException(this.getClass().getSimpleName() + " can have range from: " + getLowestValue() + " to: " + getHighestValue() + "!");
                } else {
                    return coordinate;
                }
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Please enter correct " + this.getClass().getName() + " value!");
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
