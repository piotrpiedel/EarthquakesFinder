package domain.coordinates;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CoordinatesTest {

    @Test
    public void mapLongitudeAndLatitudeToCoordinates_ReturnEqualsToValues() {
        //given
        double longitudeValue = 30.0;
        double latitudeValue = 20.0;

        //when
        Coordinates coordinates = new Coordinates(
                new Longitude(longitudeValue), new Latitude(latitudeValue));

        //then
        assertEquals(30, coordinates.getLongitude().getValue(), 0.00001);
        assertEquals(20, coordinates.getLatitude().getValue(), 0.00001);
    }

}