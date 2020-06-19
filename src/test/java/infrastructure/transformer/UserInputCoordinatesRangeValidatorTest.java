package infrastructure.transformer;

import infrastructure.exception.IncorrectCoordinateValueException;
import infrastructure.exception.IncorrectCoordinateValueRangeException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserInputCoordinatesRangeValidatorTest {

    UserInputCoordinatesRangeValidator userInputToCoordinates;

    @Before
    public void setUp() throws Exception {
        userInputToCoordinates = new UserInputCoordinatesRangeValidator();
    }

    @Test
    public void checkLatitudeRangeAndParseValue_WhenValueIsCorrect_ReturnParsedDouble()
            throws IncorrectCoordinateValueRangeException, IncorrectCoordinateValueException {
        //given
        String line = "50";

        //when
        double result = userInputToCoordinates.validateValueWithLatitudeRangeAndConvertToDouble(line);

        //then
        assertEquals(50, result, 0.00001);
    }

    @Test
    public void checkLongitudeRangeAndParseValue_WhenValueIsCorrect_ReturnParsedDouble()
            throws IncorrectCoordinateValueRangeException, IncorrectCoordinateValueException {
        //given
        String line = "50";

        //when
        double result = userInputToCoordinates.validateValueWithLongitudeRangeAndConvertToDouble(line);

        //then
        assertEquals(50, result, 0.00001);
    }

}