package distancecalc;

import models.Coordinates;

public abstract class DistanceCalculator {

    abstract double calculateDistance(double latitude1, double longitude1, double latitude2, double longitude2);

    public double calculateDistance(Coordinates coordinates1, Coordinates coordinates2) {
        return calculateDistance(coordinates1.getLatitude(), coordinates1.getLongitude(), coordinates2.getLatitude(), coordinates2.getLongitude());
    }
}
