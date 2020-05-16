package infrastructure.transformer;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserInputToCoordinatesTest {

    UserInputToCoordinates userInputToCoordinates;

    @Before
    public void setUp() throws Exception {
        userInputToCoordinates = new UserInputToCoordinates();
    }

    @Test
    public void checkLatitudeRangeAndParseValue_WhenValueIsCorrect_ReturnParsedDouble() {
        //given
        String line = "50";

        //when
        double result = userInputToCoordinates.checkLatitudeRangeAndParseValue(line);

        //then
        assertEquals(50, result, 0.00001);
    }

    @Test
    public void checkLongitudeRangeAndParseValue_WhenValueIsCorrect_ReturnParsedDouble() {
        //given
        String line = "50";

        //when
        double result = userInputToCoordinates.checkLongitudeRangeAndParseValue(line);

        //then
        assertEquals(50, result, 0.00001);
    }

}