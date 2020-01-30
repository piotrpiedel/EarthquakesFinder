package distancecalc;

import domain.Coordinates;

public interface DistanceCalculator {

    double calculateDistance(double latitude1, double longitude1, double latitude2, double longitude2);

    default double calculateDistance(Coordinates coordinates1, Coordinates coordinates2) {
        return calculateDistance(coordinates1.getLatitude(), coordinates1.getLongitude(), coordinates2.getLatitude(), coordinates2.getLongitude());
    }
}
