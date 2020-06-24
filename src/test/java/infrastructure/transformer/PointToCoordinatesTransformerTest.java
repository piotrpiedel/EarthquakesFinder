package infrastructure.transformer;

import domain.coordinates.Coordinates;
import org.geojson.Point;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PointToCoordinatesTransformerTest {

    PointToCoordinatesTransformer pointToCoordinatesTransformer;

    @Before
    public void setUp() {
        pointToCoordinatesTransformer = new PointToCoordinatesTransformer();
    }

    @Test
    public void mapPointToCoordinates_ReturnCorrectValuesOfCoordinates() {
        //given
        double longitudeValue = 30.0;
        double latitudeValue = 20.0;

        //when
        Coordinates coordinates = pointToCoordinatesTransformer
                .map(new Point(longitudeValue, latitudeValue));

        //then
        assertEquals(30, coordinates.getLongitude().getValue(), 0.00001);
        assertEquals(20, coordinates.getLatitude().getValue(), 0.00001);
    }
}