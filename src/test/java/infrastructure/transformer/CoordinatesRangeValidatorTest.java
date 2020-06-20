package infrastructure.transformer;

import infrastructure.exception.IncorrectCoordinateValueException;
import infrastructure.exception.IncorrectCoordinateValueRangeException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CoordinatesRangeValidatorTest {

    CoordinatesRangeValidator coordinatesRangeValidator;

    @Before
    public void setUp() throws Exception {
        coordinatesRangeValidator = new CoordinatesRangeValidator();
    }

    @Test
    public void checkLatitudeRangeAndParseValue_WhenValueIsCorrect_ReturnParsedDouble()
            throws IncorrectCoordinateValueRangeException, IncorrectCoordinateValueException {
        //given
        String line = "50";

        //when
        double result = coordinatesRangeValidator.validateValueWithLatitudeRangeAndConvertToDouble(line);

        //then
        assertEquals(50, result, 0.00001);
    }

    @Test
    public void checkLongitudeRangeAndParseValue_WhenValueIsCorrect_ReturnParsedDouble()
            throws IncorrectCoordinateValueRangeException, IncorrectCoordinateValueException {
        //given
        String line = "50";

        //when
        double result = coordinatesRangeValidator.validateValueWithLongitudeRangeAndConvertToDouble(line);

        //then
        assertEquals(50, result, 0.00001);
    }

}