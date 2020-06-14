package application.distancecalc;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HaversineDistanceCalculatorTest {

    DistanceCalculator distanceCalculator = new HaversineDistanceCalculator();

    @Test
    public void calculateDistance_ReturnCorrectDistanceInKm() {
        //given
        double longitudeValueStartPoint = 42.990967;
        double latitudeValueStartPoint = -71.463767;

        double longitudeValueDestinationPoint = 50.049683;
        double latitudeValueDestinationPoint = 19.944544;

        //when
        double result = distanceCalculator
                .calculateDistance(longitudeValueStartPoint, latitudeValueStartPoint,
                        longitudeValueDestinationPoint, latitudeValueDestinationPoint);

        //then
        //expected result from site https://www.movable-type.co.uk/scripts/latlong.html
        assertEquals(6589, result, 0.1);
    }
}