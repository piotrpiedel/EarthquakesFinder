package application.distancecalc;

import domain.model.Coordinates;

public interface DistanceCalculator {

    double calculateDistance(double latitude1, double longitude1, double latitude2, double longitude2);

    default double calculateDistance(Coordinates coordinates1, Coordinates coordinates2) {
        return calculateDistance(coordinates1.getLatitude().getValue(),
                coordinates1.getLongitude().getValue(),
                coordinates2.getLatitude().getValue(),
                coordinates2.getLongitude().getValue());
    }
}
