package infrastructure.transformer;

import domain.coordinates.Coordinates;
import domain.coordinates.Latitude;
import domain.coordinates.Longitude;
import org.geojson.Point;

public class PointToCoordinatesTransformer {

    public Coordinates map(Point point) {
        return new Coordinates(
                new Longitude(point
                        .getCoordinates()
                        .getLongitude()),
                new Latitude(point
                        .getCoordinates()
                        .getLatitude())
        );
    }
}
