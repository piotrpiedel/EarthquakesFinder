package infrastructure.userinteractions;

import domain.model.EarthquakeBasicInfoWithDistanceToIndicatedPoint;

import java.util.List;

public interface EarthquakePrinter {

    void printNearbyEarthquakes(List<EarthquakeBasicInfoWithDistanceToIndicatedPoint> earthquakesToPrint);
}
