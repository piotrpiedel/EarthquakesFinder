package util;

import domain.GeographicCoordinates;

public class CoordinatesParser {

    private static final double LOWEST_LATITUDE = -90.0;
    private static final double HIGHEST_LATITUDE = 90.0;
    private static final double LOWEST_LONGITUDE = -180.0;
    private static final double HIGHEST_LONGITUDE = 180.0;

    public static double parseLatitude(String line) {
        return parse(line, GeographicCoordinates.LATITUDE);
    }

    public static double parseLongitude(String line) {
        return parse(line, GeographicCoordinates.LONGITUDE);
    }

    private static double parse(String line, GeographicCoordinates typeOfCoordinate) {
        double lowestValue;
        double highestValue;
        if (typeOfCoordinate.equals(GeographicCoordinates.LATITUDE)) {
            lowestValue = LOWEST_LATITUDE;
            highestValue = HIGHEST_LATITUDE;
        } else {
            lowestValue = LOWEST_LONGITUDE;
            highestValue = HIGHEST_LONGITUDE;
        }

        if (line == null || line.length() == 0 || line.chars().allMatch(Character::isWhitespace)) {
            throw new IllegalArgumentException(" Value can not be null, empty or blank!");
        } else {
            try {
                double coordinate = Double.parseDouble(line);
                if (coordinate < lowestValue || coordinate > highestValue) {
                    throw new IllegalArgumentException(typeOfCoordinate.name() + " can have range from: " + lowestValue + " to: " + highestValue + "!");
                } else {
                    return coordinate;
                }
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Please enter correct " + typeOfCoordinate.name() + " value!");
            }
        }
    }

}
