package domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class GeographicCoordinateTest {

    @Test
    public void checkValueWithGivenRangeAndParseValueToDouble_WhenValueIsBlank_ThrowException() {
        assertThrows(IllegalArgumentException.class, () -> GeographicCoordinate.checkValueWithGivenRangeAndParseValueToDouble(" ", 0, 100));
    }

    @Test
    public void checkValueWithGivenRangeAndParseValueToDouble_WhenValueIsOutOfRange_ThrowException() {
        assertThrows(IllegalArgumentException.class, () -> GeographicCoordinate.checkValueWithGivenRangeAndParseValueToDouble("0", 1, 100));
        assertThrows(IllegalArgumentException.class, () -> GeographicCoordinate.checkValueWithGivenRangeAndParseValueToDouble("101", 1, 100));
    }

    @Test
    public void checkValueWithGivenRangeAndParseValueToDouble_WhenValueIsInRange_ReturnParsedValue() {
        assertEquals(50, GeographicCoordinate.checkValueWithGivenRangeAndParseValueToDouble("50", 20, 100), 0.00001);
    }

    @Test
    public void checkValueWithGivenRangeAndParseValueToDouble_WhenValueIsEqualToRangeStart_ReturnParsedValue() {
        assertEquals(20, GeographicCoordinate.checkValueWithGivenRangeAndParseValueToDouble("20", 20, 100), 0.00001);
    }

    @Test
    public void checkValueWithGivenRangeAndParseValueToDouble_WhenValueIsEqualToRangeEnd_ReturnParsedValue() {
        assertEquals(100, GeographicCoordinate.checkValueWithGivenRangeAndParseValueToDouble("100", 20, 100), 0.00001);
    }

}