package distancecalc;

import static java.lang.Math.atan2;
import static java.lang.Math.cos;
import static java.lang.Math.sin;
import static java.lang.Math.sqrt;
import static java.lang.Math.toRadians;

public class DistanceCalculatorHaversine implements DistanceCalculator {

    @Override
    public double calculateDistance(double latitude1, double longitude1, double latitude2, double longitude2) {
        int earthRadius = 6371;  // Earth radius in km
        double deltaLatitude = toRadians(latitude2 - latitude1);
        double deltaLongitude = toRadians(longitude2 - longitude1);
        double a = sin(deltaLatitude / 2) * sin(deltaLatitude / 2)
                + cos(toRadians(latitude1)) * cos(toRadians(latitude2))
                * sin(deltaLongitude / 2) * sin(deltaLongitude / 2);
        double d = 2 * atan2(sqrt(a), sqrt(1 - a));
        return d * earthRadius;
    }
}
