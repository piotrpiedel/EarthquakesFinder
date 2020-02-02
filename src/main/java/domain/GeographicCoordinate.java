package domain;

public abstract class GeographicCoordinate {

    protected abstract double getLowestValue();

    protected abstract double getHighestValue();

    protected double value;

    public double getValue() {
        return value;
    }

    protected GeographicCoordinate(double value) {
        this.value = value;
    }

    protected GeographicCoordinate(String value) {
        this.value = parse(value);
    }

    public double parse(String line) {
        if (line == null || line.length() == 0 || line.chars().allMatch(Character::isWhitespace)) {
            throw new IllegalArgumentException("Values can't be blank!");
        } else {
            try {
                double coordinate = Double.parseDouble(line);
                if (coordinate < getLowestValue() || coordinate > getHighestValue()) {
                    throw new IllegalArgumentException(this.getClass().getName() + " can have range from: " + getLowestValue() + " to: " + getHighestValue() + "!");
                } else {
                    return coordinate;
                }
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Please enter correct " + this.getClass().getName() + " value!");
            }
        }
    }

}
