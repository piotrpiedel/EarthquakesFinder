package infrastructure.transformer;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.geojson.Feature;
import org.geojson.FeatureCollection;
import org.junit.Before;
import org.junit.Test;

import java.io.FileReader;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FeatureToEarthquakeBasicInfoTransformerTest {

    FeatureToEarthquakeBasicInfoTransformer featureToEarthquakeBasicInfoTransformer;
    List<Feature> featureList;

    @Before
    public void setUp() throws Exception {
        featureList = new ObjectMapper()
                .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
                .readValue(
                        new FileReader("src/test/resources/jsonWithCoordinatesDuplicates.txt"),
                        FeatureCollection.class)
                .getFeatures();
        featureToEarthquakeBasicInfoTransformer = new FeatureToEarthquakeBasicInfoTransformer();
    }

    @Test
    public void mapFeaturesToTheSameNumberOfEarthquakesPlacesToCoordinates() {
        //given
        //File has 21 features so it should be mapped to 21 earthquakes

        //when
        int result = featureToEarthquakeBasicInfoTransformer.map(featureList).size();

        //then
        assertEquals(21, result);

    }
}