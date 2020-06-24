package infrastructure.userinteractions;

import domain.earthquake.EarthquakeBasicInfoWithDistanceToIndicatedPoint;

import java.util.List;

public interface EarthquakePrinter {

    void printEarthquakes(
            List<EarthquakeBasicInfoWithDistanceToIndicatedPoint> earthquakesToPrint);
}
