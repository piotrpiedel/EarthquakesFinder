package util;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.EarthquakePlaceToCoordinates;
import org.geojson.Feature;
import org.geojson.FeatureCollection;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class EarthquakesUtilTest {

    List<Feature> featureList = null;
    List<EarthquakePlaceToCoordinates> earthquakePlaceToCoordinates = null;

    @Before
    public void setUp() throws Exception {
        featureList = new ObjectMapper()
                .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
                .readValue(new FileReader("src/test/resources/jsonWithCoordinatesDuplicates.txt"), FeatureCollection.class)
                .getFeatures();
        earthquakePlaceToCoordinates = EarthquakesUtil.mapFeaturesToEarthquakePlaceToCoordinatesList(featureList);

    }

    //File has 21 features so it should be mapped to 21 earthquakes
    @Test
    public void mapFeaturesToTheSameNumberOfEarthquakesPlacesToCoordinates() {
        assertEquals(21, EarthquakesUtil.mapFeaturesToEarthquakePlaceToCoordinatesList(featureList).size());
    }

    //File has 21 earthquakes and 3 duplicates so it should be 19 after filter
    @Test
    public void filterEarthquakesWithCoordinatesFrom21WithDuplicatesTo19Unique() {
        assertEquals(19, EarthquakesUtil.filterEarthquakesWithCoordinatesDuplicates(earthquakePlaceToCoordinates).size());
    }
}