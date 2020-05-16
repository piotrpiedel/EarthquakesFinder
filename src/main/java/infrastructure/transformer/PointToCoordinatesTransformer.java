package infrastructure.transformer;

import domain.model.Coordinates;
import domain.model.Latitude;
import domain.model.Longitude;
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
