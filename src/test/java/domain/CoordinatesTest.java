package domain;

import org.geojson.Point;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class CoordinatesTest {

    @Test
    public void mapPointToCoordinates_ReturnEqualsToMapLongitudeAndLatitudeToCoordinates() {
        Coordinates coordinates = new Coordinates(new Point(20, 30));
        assertEquals(new Coordinates(new Longitude(20), new Latitude(30)), coordinates);
    }

    @Test
    public void mapPointToCoordinates_ReturnCorrectValuesOfCoordinates() {
        Coordinates coordinates = new Coordinates(new Point(20, 30));
        assertEquals(20, coordinates.getLongitude().getValue(), 0.00001);
        assertEquals(30, coordinates.getLatitude().getValue(), 0.00001);
    }

}