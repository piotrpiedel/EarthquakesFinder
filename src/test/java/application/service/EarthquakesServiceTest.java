package application.service;

import application.distancecalc.HaversineDistanceCalculator;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.earthquake.EarthquakeBasicInfo;
import infrastructure.client.EarthquakesApiClient;
import infrastructure.transformer.FeatureToEarthquakeBasicInfoTransformer;
import org.geojson.Feature;
import org.geojson.FeatureCollection;
import org.junit.Before;
import org.junit.Test;

import java.io.FileReader;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class EarthquakesServiceTest {

    List<Feature> featureList;
    List<EarthquakeBasicInfo> earthquakePlaceToCoordinates;
    EarthquakesService earthquakesService;
    FeatureToEarthquakeBasicInfoTransformer featureToEarthquakeBasicInfoTransformer;

    @Before
    public void setUp() throws Exception {
        earthquakesService = new EarthquakesService(new HaversineDistanceCalculator(),
                new EarthquakesApiClient(), new FeatureToEarthquakeBasicInfoTransformer());

        featureList = new ObjectMapper()
                .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
                .readValue(
                        new FileReader("src/test/resources/jsonWithCoordinatesDuplicates.txt"),
                        FeatureCollection.class)
                .getFeatures();

        featureToEarthquakeBasicInfoTransformer = new FeatureToEarthquakeBasicInfoTransformer();
        earthquakePlaceToCoordinates = featureToEarthquakeBasicInfoTransformer
                .map(featureList);
    }

    @Test
    public void filterEarthquakesWithCoordinatesFrom21WithDuplicatesTo19Unique() {
        //given
        //File jsonWithCoordinatesDuplicates.txt has 21 earthquakes and 3 duplicates so it should be 19 after filter

        //when
        int result = earthquakesService
                .filterEarthquakesWithDuplicatedCoordinates(earthquakePlaceToCoordinates).size();

        //then
        assertEquals(19, result);
    }
}